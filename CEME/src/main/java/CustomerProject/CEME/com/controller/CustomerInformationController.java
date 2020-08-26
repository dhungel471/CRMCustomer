package CustomerProject.CEME.com.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import CustomerProject.CEME.com.model.CustomerInformation;
import CustomerProject.CEME.com.service.CustomerInformationService;

@RestController
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerInformationController {
    @Autowired
    private CustomerInformationService cemeCustomerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<CustomerInformation> getAllCustomer() {
        return cemeCustomerService.getAllCustomer();
    }

  @RequestMapping(method=RequestMethod.POST)
  public void addNewCustomer(@RequestBody CustomerInformation custInfo) {
    cemeCustomerService.addNewCustomer(custInfo);
  }

  @RequestMapping(method=RequestMethod.PUT, value="/{id}")
  public void updateCustomer(@RequestBody CustomerInformation custInfo, @PathVariable("id") String id) {
    cemeCustomerService.updateCustomer(id, custInfo);
  }
  @CrossOrigin
  @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
  public void deleteCustomer(@PathVariable("id") String id){
    cemeCustomerService.deleteCustomer(id);
  }
}
