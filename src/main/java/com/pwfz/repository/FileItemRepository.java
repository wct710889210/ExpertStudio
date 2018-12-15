package com.pwfz.repository;

import com.pwfz.entity.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileItemRepository extends JpaRepository<FileItem,Integer> {
}
