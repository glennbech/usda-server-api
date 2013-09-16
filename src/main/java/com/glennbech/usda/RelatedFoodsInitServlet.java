package com.glennbech.usda;

import com.glennbech.usda.model.SimilarFoods;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;

/**

 */
public class RelatedFoodsInitServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        InputStream is = config.getServletContext().getResourceAsStream("/WEB-INF/distances.csv");
        if (is == null ) {
            throw new IllegalArgumentException();
        }
        try {
            long now = System.currentTimeMillis();
            SimilarFoods.initialize(is);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}
