package com.glennbech.usda;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
        long now = System.currentTimeMillis();
//            SimilarFoods.initialize(is);
    }
}
