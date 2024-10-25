package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {
    private String upLoadFileName;
    private String storeFileName;

    public UploadFile(String upLoadFileName, String storeFileName) {
        this.upLoadFileName = upLoadFileName;
        this.storeFileName = storeFileName;
    }
}
