package com.github.seratch.jslack.api.methods.response.files.remote;

import com.github.seratch.jslack.api.methods.SlackApiResponse;
import com.github.seratch.jslack.api.model.File;
import com.github.seratch.jslack.api.model.ResponseMetadata;
import lombok.Data;

import java.util.List;

@Data
public class FilesRemoteListResponse implements SlackApiResponse {

    private boolean ok;
    private String warning;
    private String error;
    private String needed;
    private String provided;

    private List<File> files;
    private ResponseMetadata responseMetadata;
}