package com.example.test.controller;

import com.example.test.dto.NhanVienDto;
import com.example.test.service.NhanVienService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public ResponseEntity<List<NhanVienDto>> getAllNhanVien() {
        List<NhanVienDto> nhanVienDtos = nhanVienService.getAllNhanVien();
        return ResponseEntity.ok(nhanVienDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<NhanVienDto> getOne(@PathVariable("id") Long id) {
        NhanVienDto nhanVienDto = nhanVienService.getOne(id);
        return ResponseEntity.ok(nhanVienDto);
    }

    @PostMapping
    public ResponseEntity<NhanVienDto> createNhanVien(@RequestBody NhanVienDto nhanVienDto) {
        NhanVienDto savedNhanVien = nhanVienService.createNhanVien(nhanVienDto);
        return new ResponseEntity<>(savedNhanVien, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<NhanVienDto> updateNhanVien(@PathVariable("id") Long id,
                                                      @RequestBody NhanVienDto nhanVienDto) {
        NhanVienDto savedNhanVien = nhanVienService.updateNhanVien(id, nhanVienDto);
        return ResponseEntity.ok(savedNhanVien);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNhanVien(@PathVariable("id") Long id) {
        nhanVienService.deleteNhanVien(id);
        return ResponseEntity.ok("Delete thành công");
    }

    @GetMapping("/page")
    public ResponseEntity<Page<NhanVienDto>> getNhanVienPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        Page<NhanVienDto> list = nhanVienService.getNhanVienPage(page, size);
        return ResponseEntity.ok(list);
    }

    @PutMapping("trang-thai/{id}")
    public ResponseEntity<NhanVienDto> updateNhanVienTrangThai(@PathVariable("id") Long id,
                                                               @RequestBody NhanVienDto nhanVienDto) {
        NhanVienDto savedNhanVien = nhanVienService.updateNhanVienByTrangThai(id, nhanVienDto);
        return ResponseEntity.ok(savedNhanVien);
    }

}
