package com.example.pinterest.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Path;
import java.util.stream.Stream;

import com.example.pinterest.Service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

    private final StorageService storageService;

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        Stream<Path> p = storageService.loadAll();
        List<String> mapper = p.map(path -> MvcUriComponentsBuilder
                .fromMethodName(FileController.class, "serveFile", path.getFileName().toString()).build().toUri()
                .toString()).collect(Collectors.toList());
        model.addAttribute("files", mapper);
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        String at = "attachment; filename=\"" + file.getFilename() + "\"";
        ResponseEntity.BodyBuilder bu = ResponseEntity.ok();
        ResponseEntity.BodyBuilder builder = bu.header(HttpHeaders.CONTENT_DISPOSITION, at);
        return builder.body(file);

    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

}