# RepCamp-Java-SDK-Example

## Motivation
This repo contains an example and a **Getting Started** Project for RepCamp's Java SDK. The objective is to get familiar with the SDK and to provide, a proposal of an architecture for synchronizer application. With the help of the SDK you will be able to retrieve the data from whatever source you have (ERP, CRM, E-Commerce, etc.) and upload it smoothly to your account at RepCamp.com. 

## What is RepCamp?
RepCamp is a powerful **Mobile Application** that provides the Sales Representatives with all the information needed to carry out a productive and comprehensive Commercial Management. Apart from having all the customer information in a single Dashboard -georeferencing, statistics, orders, etc.- you’ll be able to show an elegant **Product Catalog** by categories and brands, with spceial prices, promotions, images, etc. so you can **make Orders** on the spot, without further delay, instantly closing business deals wherever you are. RepCamp is powered by **Kriter Software**, founded in 1989, who has been manufacturing management software and providing business solutions for huge variety of companies.

## Partner Program
Join the **Partner Program** to earn client revenue, discover how [here](http://www.repcamp.com/en/partner).
And access exclusive developer resources [here](http://developers.repcamp.com).

## What does the RepCamp SDK includes?
- A set of platform **Objects** that RepCamp has such as: Customers, Products, Categories, PriceLists, etc.
- A **REST Services** interface so you forget about http calls and focus on transffering back and forth the data.
- A **Main Controller**: The RepCampAPI is the main cantroller wich you will be using for authenticating and centralizing the API calls.

## RepCamp Java SDK Installation
```c
<repository>
      <id>kriter-code</id>
      <name>kriter-code-releases</name>
      <url>http://code.kriter.net:8081/artifactory/libs-release-local</url>
</repository>

<dependency>
      <groupId>net.kriter.rcsdk</groupId>
      <artifactId>repcamp-sdk</artifactId>
      <version>1.0.0</version>
</dependency>
```
## Dependencies
```c
<dependency>
      <groupId>com.sun.jersey</groupId>
      <artifactId>jersey-client</artifactId>
      <version>1.18.3</version>
</dependency>
<dependency>
      <groupId>com.sun.jersey</groupId>
      <artifactId>jersey-core</artifactId>
      <version>1.18.3</version>
</dependency>
<dependency>
      <groupId>com.sun.jersey</groupId>
      <artifactId>jersey-json</artifactId>
      <version>1.18.3</version>
</dependency>
<dependency>
      <groupId>org.codehaus.jackson</groupId>
      <artifactId>jackson-mapper-asl</artifactId>
      <version>1.9.13</version>
</dependency>
```
## Lets Code!

- Instantiate the main RepCamp SDK controller
```c
RepCampAPI repcampAPI = new RepCampAPI();
```
- Specify API data to start up the authentication.
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
- Set API data to the SDK
```c
repcampAPI.setAPIData(apidata);
```
- Authenticate your self, just to test the API key out.
```c
if(repcampAPI.authenticateMe()) System.out.println("Authentication ----------- OK");
else System.out.println("Authentication ----------- FAILED");
```
**Upload**

- Create a Customer
```c
Customer customer = new Customer();
//Set all necessary atributes
customer.setCode("CT0001");
customer.setFiscal_name("Kriter Software, S.L.");
customer.setComercial_name("Kriter Software");
customer.setVat_number("D58709832");
customer.setTelephone("+34 937575997");
customer.setTelephone_2("");
customer.setEmail("support@repcamp.com");
customer.setAddress("Pablo Iglesias 63");
customer.setAddress_2("PB L1");
customer.setCity("Mataró");
customer.setZip("08302");
customer.setState("Barcelona (BCN)");
customer.setCountry("SPAIN");
customer.setLatitude(new BigDecimal("41.531395"));
customer.setLongitude(new BigDecimal("2.43232"));
customer.setPayment_method("Bank Transfer 30 days");
customer.setDiscount(new BigDecimal("10"));
customer.setDescription("This is just a comment area");
customer.setStatus((short) 1);
customer.setPricelist("01");
customer.setLanguage("en");
//etc.
```
- Upload it and handle the response
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
