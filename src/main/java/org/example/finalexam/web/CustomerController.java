package org.example.finalexam.web;

import lombok.AllArgsConstructor;
import org.example.finalexam.entities.Customer;
import org.example.finalexam.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor



public class CustomerController {
    @Autowired
    private Repo repo;

    @GetMapping(path = "/")
    public String initialPage(Model model) {
        // Ensure initial data is available
        repo.getAllCustomers(); // Ensure list is initialized
        model.addAttribute("customers", repo.getAllCustomers());
        model.addAttribute("customer", new Customer());
        return "Main";
    }
    @PostMapping("/addOrUpdateCustomer")
    public String addOrUpdateCustomer(@ModelAttribute Customer customer, Model model) {
        if (customer.getId() > 0) { // Check if ID is greater than 0 (assuming ID 0 means new customer)
            // Update existing customer
            repo.updateCustomer(customer);
        } else {
            // Add new customer
            repo.addCustomer(customer);
        }

        // Refresh the list of customers to show the latest data in the view
        model.addAttribute("customers", repo.getAllCustomers());

        // Create a new Customer object for the form to be ready for new entries
        model.addAttribute("customer", new Customer());

        // Redirect to a different view or the same view (if you want to stay on the same page)
        return "Main"; // Change this if needed to the name of your actual view
    }

    @GetMapping(path = "/edit")
    public String editCustomer(@RequestParam("id") int id, Model model) {
        Customer customer = repo.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("error", "Customer not found");
        }
        model.addAttribute("customers", repo.getAllCustomers());
        return "Main";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        // Perform the delete operation
        repo.deleteCustomer(id);

        // Add an attribute to the redirect, e.g., a success message
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully.");

        // Redirect to the main page to show updated customer list
        return "redirect:/"; // Adjust the URL based on your application's routing
    }

}

