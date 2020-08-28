package CustomerProject.CEME.com.service;

import java.util.Collection;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CustomerProject.CEME.com.data.CustomerInformationRepo;
import CustomerProject.CEME.com.model.CustomerInformation;

@Service
public class CustomerInformationService {
    @Autowired
    private CustomerInformationRepo custRepo;

    //Get List of Customer
    public Collection<CustomerInformation> getAllCustomer() {
        return custRepo.findAll();
    }

    //Get a list of customer by ID
    public Optional<CustomerInformation> getCustomerWithID(String id){
        return custRepo.findById(id);
    }

    //Add new Customer
    public void addNewCustomer(CustomerInformation custInfo){
        custRepo.insert(custInfo);
    }

    //Update Customer
    public void updateCustomer(String id, CustomerInformation custInfo){
        custRepo.save(custInfo);
    }

    //Delete Customer
    public void deleteCustomer(String id){
        custRepo.deleteById(id);
    }
}

