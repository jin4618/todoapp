package org.example.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.example.todoapp.entity.FileEntity;
import org.example.todoapp.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileDatabaseService {
    private final FileRepository fileRepository;

    @Transactional
    public FileEntity saveFileMetadata(String uuid, String path, String originFilename, long size, String mimeType) {   // 실제 파일이 아닌 파일 정보 저장
        FileEntity fileEntity = new FileEntity();
        fileEntity.setUuid(uuid);
        fileEntity.setPath(path);
        fileEntity.setOriginalFilename(originFilename);
        fileEntity.setSize(size);
        fileEntity.setMimeType(mimeType);

        return fileRepository.save(fileEntity);
    }

    public Optional<FileEntity> getFileMetadata(String uuid) {
        return fileRepository.findByUuid(uuid);
    }
}
