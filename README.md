# Connected Cities 

###Overview
Connected cities application is to check and validate if there is any connectivity present between any two given
 location.
 
###Code style
 This project use standard intelliJ code style formatting.
 
###Build

```
git clone https://github.com/anilmann/connected-cities.git
mvn clean test
mvn spring-boot:run
``` 
 
###Tech/Framework used
- Java 8
- SpringBoot 2.3.1
- Maven
- Mockito
- JUnit
 
###Features
This program reads input (source city and destination city) from given text file and store all the data in Set.
It will create disjoint set in case 2 cities are not present in previous set of cities.

For example the input in file is as below:
 ```text
A- B
B-C
C-J
X- Z
```
So the program will read this input and will store data as below:
```
[[A, B, C, J],
[X, Z]]
```

Application will return ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2.
Any unexpected input should result in a ’no’ response. 
 
###How to use?
* It will be deployed as a Spring Boot App on port **8080** and expose endpoint:
 http://localhost:8080/connected?origin=city1&destination=city2
* City can be entered in uppercase or lowercase, there is no impact on result.
* If there is any route available between your cities, you will see “yes” in output. The route could be direct link or
 an indirect link.
* If there is no route available (whether its direct or indirect) between given source and destination city, output
 will be” no” .

###Tests
* Given a text file with information:
    ```
    A- B
    B-C
    C-J
    X- Z
    ```
* Validates if there is a route between **A – B**: Output should be **yes** as path exists between these 2 points
* Validates if there is a route between **b – c**: Output should be **yes** as there is a route between these two
 points
 and small case or upper case does not have any impact on output
* Validates if there is a route between **a – a**: Output should be **yes**
* Validates if there is a route between **B -  Z**: Output should be **no** as there is no route between these two
 points
* Validate if there is a route between **A – J**: Output should be **yes** as there is in-direct link between these two
 points
* Validate if unexpected input for ex. **N - M**: Output should be **no**.

### Developer
* Anil Mann