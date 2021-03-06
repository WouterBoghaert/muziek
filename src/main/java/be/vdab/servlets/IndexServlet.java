package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.AlbumService;
import be.vdab.util.StringUtils;

@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final transient AlbumService albumService = new AlbumService();
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {
			String idString = request.getParameter("id");
			if(StringUtils.isLong(idString)) {
				albumService.readMetArtiestEnTracks(Long.parseLong(idString))
					.ifPresent(album -> request.setAttribute("album", album));
			}
		}
		else {
			request.setAttribute("albums", albumService.findAllMetArtiest());
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
