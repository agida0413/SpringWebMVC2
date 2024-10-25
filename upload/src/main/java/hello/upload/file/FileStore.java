package hello.upload.file;

import com.sun.source.tree.BinaryTree;
import hello.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename){
        return fileDir + filename;
    }

    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if(!multipartFile.isEmpty()){
                UploadFile uploadFile = storeFile(multipartFile);
                storeFileResult.add(uploadFile);
            }
        }
        return storeFileResult;
    }

    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()){
            return  null;
        }

        String originalFilename = multipartFile.getOriginalFilename();

        String ext = extractExt(originalFilename);

        String uuid = UUID.randomUUID().toString();

        String storeFilename = uuid + "." + ext;

        multipartFile.transferTo(new File(getFullPath(storeFilename)));

        return  new UploadFile(originalFilename,storeFilename);
    }


    private String extractExt(String originalFilename){
        int index = originalFilename.lastIndexOf(".");
        originalFilename=originalFilename.substring(index+1);

        return  originalFilename;
    }
}
