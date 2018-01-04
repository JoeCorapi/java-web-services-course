package com.bharaththippireddy.trainings.jaxrs.attachments;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;


public class FileService {

	private static final String FILE_PATH = "/Users/Ubnik/Desktop/uploads/uploaded.jpg";

	@POST
	@Path("/upload")
	public void upload(List<Attachment> attachments) throws IOException{
		for (Attachment attachment: attachments) {
			InputStream inputStream = attachment.getDataHandler().getInputStream();
			copyFile(inputStream);
		}
	}

	@GET
	@Path("/download")
	public Response download(){
		java.nio.file.Path path = Paths.get(FILE_PATH);
		//File file = new File(FILE_PATH);

		Response.ResponseBuilder responseBuilder = Response.ok(path.toFile());
		responseBuilder.header("Content-Disposition", "attachment;filename=downloaded.jpg");

		return responseBuilder.build();
	}

	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
	}

}