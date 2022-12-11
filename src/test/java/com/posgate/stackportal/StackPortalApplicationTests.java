package com.posgate.stackportal;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StackPortalApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(StackPortalApplicationTests.class);

	private final String GIT_URL = "git@github.com:philipposgate/stackportal.git";
	private final String HTTPS_URL = "https://github.com/philipposgate/stackportal.git";
	private final String SSH_URL = "ssh://git@github.com:philipposgate/stackportal.git";

	@Test
	void contextLoads() {
	}

	@Test
	public void should_connect_to_public_repo() throws Exception {

		// prepare a new folder for the cloned repository
		File localPath = File.createTempFile("TestGitRepository", "");
		logger.info("Local working directory: " + localPath);
		localPath.delete();

		// then clone
		Git result = Git.cloneRepository()
				.setURI(HTTPS_URL)
				.setDirectory(localPath)
				.call();

		logger.info("Local .git directory: " + result.getRepository().getDirectory());

		String path = localPath.getAbsolutePath() + "/data/data.json";
		logger.info("path to file: " + path);
		File file = new File(localPath.getAbsolutePath() + "/data/data.json");

		Assertions.assertTrue(file.exists());
	}

	// @Test
	// public void should_connect_to_public_ssh() throws IOException,
	// GitAPIException {
	// final String REMOTE_URL = "git@github.com:philipposgate/stackportal.git";

	// SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
	// @Override
	// protected void configure(OpenSshConfig.Host host, Session session ) {
	// session.setUserInfo(new UserInfo() {
	// @Override
	// public String getPassphrase() {
	// return "passphrase";
	// }

	// @Override
	// public String getPassword() {return null;}

	// @Override
	// public boolean promptPassword(String message) {return false;}

	// @Override
	// public boolean promptPassphrase(String message) {return true;}

	// @Override
	// public boolean promptYesNo(String message) {return false;}

	// @Override
	// public void showMessage(String message) {}
	// });
	// }
	// };

	// File localPath = File.createTempFile("TestGitRepository", "");
	// localPath.delete();

	// try (Git result = Git.cloneRepository()
	// .setURI(REMOTE_URL)
	// .setTransportConfigCallback(transport -> {
	// SshTransport sshTransport = ( SshTransport )transport;
	// sshTransport.setSshSessionFactory( sshSessionFactory );
	// })
	// .setDirectory(localPath)
	// .call()) {
	// System.out.println("Having repository: " +
	// result.getRepository().getDirectory());
	// }

	// }
}
