package com.posgate.stackportal;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.SshTransport;
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
	public void should_connect_to_public_repo() throws IOException, GitAPIException {

		// prepare a new folder for the cloned repository
		File localPath = File.createTempFile("TestGitRepository", "");
		localPath.delete();

		// then clone
		try (Git result = Git.cloneRepository()
				.setURI(HTTPS_URL)
				.setDirectory(localPath)
				.call()) {
			// Important to close the repo after being used
			logger.info("Having repository: " + result.getRepository().getDirectory());
		}
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
