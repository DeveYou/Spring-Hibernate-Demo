package spring.com.web;

import spring.com.dao.IDao;
import spring.com.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends BaseServlet {

    private IDao<Product> productDao;

    @Override
    public void init() throws ServletException {
        super.init();
        productDao = (IDao<Product>) springContext.getBean("productDaoImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/list";
        }

        switch (action) {
            case "/list":
                listProducts(req, resp);
                break;
            case "/new":
                showNewForm(req, resp);
                break;
            case "/edit":
                showEditForm(req, resp);
                break;
            case "/view":
                viewProduct(req, resp);
                break;
            case "/delete":
                deleteProduct(req, resp);
                break;
            default:
                listProducts(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        if ("/save".equals(action)) {
            saveProduct(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/products/list");
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDao.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/product/form.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productDao.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/views/product/form.jsp").forward(req, resp);
    }

    private void viewProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productDao.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/views/product/view.jsp").forward(req, resp);
    }

    private void saveProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));

        Product product;
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            product = productDao.findById(id);
            product.setName(name);
            product.setPrice(price);
            productDao.update(product);
        } else {
            product = new Product();
            product.setName(name);
            product.setPrice(price);
            productDao.create(product);
        }

        resp.sendRedirect(req.getContextPath() + "/products/list");
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productDao.findById(id);
        if (product != null) {
            productDao.delete(product);
        }
        resp.sendRedirect(req.getContextPath() + "/products/list");
    }
}