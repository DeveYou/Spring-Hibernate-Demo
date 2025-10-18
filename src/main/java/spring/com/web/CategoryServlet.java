package spring.com.web;

import spring.com.dao.IDao;
import spring.com.entities.Category;
import spring.com.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends BaseServlet {

    private IDao<Category> categoryDao;
    private IDao<Product> productDao;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryDao = (IDao<Category>) springContext.getBean("categoryDaoImpl");
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
                listCategories(req, resp);
                break;
            case "/new":
                showNewForm(req, resp);
                break;
            case "/edit":
                showEditForm(req, resp);
                break;
            case "/view":
                viewCategory(req, resp);
                break;
            case "/delete":
                deleteCategory(req, resp);
                break;
            default:
                listCategories(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        if ("/save".equals(action)) {
            saveCategory(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/categories/list");
        }
    }

    private void listCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryDao.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/category/list.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDao.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/category/form.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryDao.findById(id);
        List<Product> products = productDao.findAll();

        req.setAttribute("category", category);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/category/form.jsp").forward(req, resp);
    }

    private void viewCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryDao.findById(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/WEB-INF/views/category/view.jsp").forward(req, resp);
    }

    private void saveCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String code = req.getParameter("code");
        String label = req.getParameter("label");
        String productIdParam = req.getParameter("productId");

        Product product = null;
        if (productIdParam != null && !productIdParam.isEmpty()) {
            int productId = Integer.parseInt(productIdParam);
            product = productDao.findById(productId);
        }

        Category category;
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            category = categoryDao.findById(id);
            category.setCode(code);
            category.setLabel(label);
            if (product != null) {
                category.setProduct(product);
            }
            categoryDao.update(category);
        } else {
            category = new Category();
            category.setCode(code);
            category.setLabel(label);
            if (product != null) {
                category.setProduct(product);
            }
            categoryDao.create(category);
        }

        resp.sendRedirect(req.getContextPath() + "/categories/list");
    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryDao.findById(id);
        if (category != null) {
            categoryDao.delete(category);
        }
        resp.sendRedirect(req.getContextPath() + "/categories/list");
    }
}