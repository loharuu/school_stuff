# In class assignments

## Assignment Description

For this assignment I needed to learn DevOps, for that I needed to learn how to use docker and jenkins.

## Technologies & Tools Used

- Frontend: JavaFX 
- Backend: Java JDK 21
- Other tools:
    - Maven 3.9.16
    - Docker
    - Jenkins
    - JUnit
    - Xming (Xserver on Linux)
    - 

## Design Approach & Implementation Method

These were made by following provided PDF.

Assignments are separates by being own modules, with names based on assignment. 
Coding was based on provided example and previous coding experience 

## Testing & Quality Assurance Steps

Every assignment used JUnit on all applicable funtions

```
@Test
void fahrenheitToCelsius() {

        assertEquals(37.77777777777778, t.fahrenheitToCelsius(100), "Should be 37.7777777778");
        assertEquals(-12.222222222222221, t.fahrenheitToCelsius(10), "Should be -12");
    }

    @Test
    void celsiusToFahrenheit() {
        assertEquals(104, t.celsiusToFahrenheit(40),"Should be 104");
        assertEquals(-22, t.celsiusToFahrenheit(-30),"Should be -22");
    }

    @Test
    void kelvinToCelsius(){
        assertEquals(26.850000000000023, t.kelvinToCelsius(300),"Should be 26.85");
        assertEquals(-23.149999999999977, t.kelvinToCelsius(250),"Should be -23.15");
    }

    @Test
    void isExtremeTemperature() {
        assertTrue(t.isExtremeTemperature(-41),"Should return true (-41)");
        assertTrue(t.isExtremeTemperature(51),"Should return true (51)");
        assertFalse(t.isExtremeTemperature(30),"Should return false (30)");
        assertFalse(t.isExtremeTemperature(-12),"Should return false (-12)");
    }
```

## Setup & Execution

### CodeCoverage
- Just run Main file in IDE
### JUnit
- Just run Main file in IDE
### Jenkins
- Just run Main file in IDE
### Docker
- `cd Docker`
- `docker build -t javamvn .`
- `docker run --rm \                                                                                          
  --add-host=host.docker.internal:host-gateway \
  -e DISPLAY=$DISPLAY \               
  -v /tmp/.X11-unix:/tmp/.X11-unix \
  javamvn`
### GuiDocker (local)
- `cd GuiDocker`
- `docker build -t javamvn .`
- `docker run --rm \                                                                                        
  --add-host=host.docker.internal:host-gateway \
  -e DISPLAY=$DISPLAY \               
  -v /tmp/.X11-unix:/tmp/.X11-unix \
  javamvn`
### GuiDocker (Docker Hub)
- `docker run --rm \                                                                                            
  --add-host=host.docker.internal:host-gateway \
  -e DISPLAY=$DISPLAY \               
  -v /tmp/.X11-unix:/tmp/.X11-unix \
  oleruu/otp1:latest`