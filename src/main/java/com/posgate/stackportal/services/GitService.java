package com.posgate.stackportal.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.jgit.api.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GitService {

    private static final Logger logger = LoggerFactory.getLogger(GitService.class);

    @Value("${stackportal.git.repo.url}")
    private String gitRepoUrl;

    private Git gitRepo;
 
    private File localPath;

    @PostConstruct
    private void init() throws Exception {
        logger.info("Remote Git url: " + gitRepoUrl);

        // prepare a new folder for the cloned repository
        localPath = File.createTempFile("StackPortalGitRepository", "");
        logger.info("Local working directory: " + localPath);

        localPath.delete();

        // then clone
        gitRepo = Git.cloneRepository()
                .setURI(gitRepoUrl)
                .setDirectory(localPath)
                .call();

        logger.info("Local .git directory: " + gitRepo.getRepository().getDirectory());

    }

    @PreDestroy
    private void destroy() {
        logger.info("closing Git repo");

        // Important to close the repo after being used
        gitRepo.close();
    }

    public File getFile(String path) {

        return new File(localPath.getAbsolutePath() + path);
    }

    public String readFileToString(String filePath) throws Exception {
        Path path = Path.of(localPath.getAbsolutePath() + filePath);
        logger.info("readFileToString(): " + path);
        return Files.readString(path);
    }
}
