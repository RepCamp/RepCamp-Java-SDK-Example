# RepCamp-Java-SDK-Example

## Motivation
This repo contains an example and a **Getting Started** Project for RepCamp's Java SDK. The objective is to get familiar with the SDK and to provide, a proposal of an architecture for synchronizer application. With the help of the SDK you will be able to retrieve the data from whatever source you have (ERP, CRM, E-Commerce, etc.) and upload it smoothly to your account at RepCamp.com. 

## What is RepCamp?
RepCamp is a powerful **Mobile Application** that provides the Sales Representatives with all the information needed to carry out a productive and comprehensive Commercial Management. Apart from having all the customer information in a single Dashboard -georeferencing, statistics, orders, etc.- you’ll be able to show an elegant ***Product Catalog*** by categories and brands, with spceial prices, promotions, images, etc. so you can ***make Orders*** on the spot, without further delay, instantly closing business deals wherever you are. RepCamp is powered by ***Kriter Software***, founded in 1989, who has been manufacturing management software and providing business solutions for huge variety of companies.

## Partner Program
Join the **Partner Program** to earn client revenue, discover how [here](http://www.repcamp.com/en/partner).
And access exclusive developer resources [here](http://developers.repcamp.com).

## What does the RepCamp SDK contain?
- A **Model** of items that RepCamp has such as: Customers, Products, Categories, PriceLists, etc.
- A **REST Services** interface so you forget about http calls and focus on transffering back and forth the data.
- A **Main Controller**: The RepCampAPI is the main cantroller wich you will be using for authenticating and centralizing the API calls.

## Lets Code!

1. Instantiate the main RepCamp SDK controller
```c
RepCampAPI repcampAPI = new RepCampAPI();
```
2. Specify API data to start up the authentication.
```c
APIData apidata = new APIData(
      config.getProperty("url"),
      config.getProperty("username"),
      config.getProperty("password"), //Sha1
      config.getProperty("apikey"),
      config.getProperty("secretkey"),
      config.getProperty("apiversion") //Just hardcode the version, for now is "v1"
);
```
3. Set API data to the SDK
```c
repcampAPI.setAPIData(apidata);
```
4. Authenticate your self, just to test the API key out.
```c
if(repcampAPI.authenticateMe()) System.out.println("Authentication ----------- OK");
else System.out.println("Authentication ----------- FAILED");
```
**Upload**

Create a Customer
```c
Customer customer = new Customer();
//Set all necessary atributes
customer.setCode("CT0001");
```
Upload it and handle the response
```c
GenericResponse resp =  GenerepcampAPI.addCustomer(customer);
if(resp.getSingleResponse() != null)
{
    if(resp.getSingleResponse().getError() != null)
    {
      System.out.println("Failed to delete customer: (CODE) " + code + " Error: " + resp.getSingleResponse().getError());
    }
}
```

**Query RepCamp to obtain its data**

```c
List<String> criteria = new ArrayList<String>();
criteria.add("code=CT0001");
List<Customer> customerslist = repcampAPI.getCustomers(criteria, 0, 1);
for(Customer customer : customerslist) System.out.println(customer.toString());
```
