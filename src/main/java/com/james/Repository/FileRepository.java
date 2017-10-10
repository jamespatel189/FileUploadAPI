package com.james.Repository;

import com.james.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository <File,Long> {
    File findById(int id);
}
