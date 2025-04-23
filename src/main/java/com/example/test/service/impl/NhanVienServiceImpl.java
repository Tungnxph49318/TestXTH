package com.example.test.service.impl;

import com.example.test.dto.NhanVienDto;
import com.example.test.entity.NhanVien;
import com.example.test.exception.ResourceNotFoundException;
import com.example.test.mapper.NhanVienMapper;
import com.example.test.repository.NhanVienRepository;
import com.example.test.service.NhanVienService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVienDto> getAllNhanVien() {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        return nhanViens.stream().map((nhanVien) -> NhanVienMapper.mapToNhanVienDto(nhanVien))
                .collect(Collectors.toList());
    }

    @Override
    public NhanVienDto getOne(Long id) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Không tìm thấy id: " + id));
        return NhanVienMapper.mapToNhanVienDto(nhanVien);
    }

    @Override
    public NhanVienDto createNhanVien(NhanVienDto nhanVienDto) {
        NhanVien nhanVien = NhanVienMapper.mapToNhanVien(nhanVienDto);
        NhanVien savedNhanVien = nhanVienRepository.save(nhanVien);
        return NhanVienMapper.mapToNhanVienDto(savedNhanVien);
    }

    @Override
    public NhanVienDto updateNhanVien(Long id, NhanVienDto nhanVienDto) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Không tìm thấy id: " + id));

        nhanVien.setTrangThai(nhanVienDto.getTrangThai());
        nhanVien.setNgayTao(nhanVienDto.getNgayTao());
        nhanVien.setNgaySua(nhanVienDto.getNgaySua());
        nhanVien.setTkFe(nhanVienDto.getTkFe());
        nhanVien.setTkFpt(nhanVienDto.getTkFpt());
        nhanVien.setTenNhanVien(nhanVienDto.getTenNhanVien());
        nhanVien.setMaNhanVien(nhanVienDto.getMaNhanVien());

        NhanVien savedNhanVien = nhanVienRepository.save(nhanVien);
        return NhanVienMapper.mapToNhanVienDto(savedNhanVien);
    }

    @Override
    public void deleteNhanVien(Long id) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Không tìm thấy id: " + id));

        nhanVienRepository.deleteById(id);
    }

    @Override
    public Page<NhanVienDto> getNhanVienPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<NhanVien> list = nhanVienRepository.findAll(pageable);
        return list.map((nhanVien) -> NhanVienMapper.mapToNhanVienDto(nhanVien));
    }

    @Override
    public NhanVienDto updateNhanVienByTrangThai(Long id, NhanVienDto nhanVienDto) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Không tìm thấy id: " + id));
        nhanVien.setTrangThai(nhanVienDto.getTrangThai());

        NhanVien savedNhanVien = nhanVienRepository.save(nhanVien);
        return NhanVienMapper.mapToNhanVienDto(savedNhanVien);
    }
}
