#[derive(Clone, Copy, Debug, PartialEq)]
pub struct Fahrenheit(f32);

#[derive(Clone, Copy, Debug, PartialEq)]
pub struct Celsius(f32);

// The original struct that stores temperature
#[derive(Clone, Copy, Debug)]
pub struct Weather {
    temperature: Fahrenheit,
}

impl Weather {
    fn new() -> Weather {
        Weather {
            temperature: Fahrenheit(0f32),
        }
    }
    fn set_temperature(&mut self, temp: Fahrenheit) {
        self.temperature = temp;
    }

    fn temperature(&self) -> Fahrenheit {
        self.temperature
    }
}

// Climate is the adapter for the Weather struct, it accepts a temperature of
// type Celsius and converts it to Fahrenheit type before it stores in the
// Weather struct, since it only stores temperatures of the Fahrenheit type.
pub struct Climate {
    wet: Weather,
}

impl Climate {
    fn new() -> Climate {
        Climate {
            wet: Weather::new(),
        }
    }

    fn set_temperature(&mut self, temp: Celsius) {
        let fahr_temp = temp.0 * 1.8f32 + 32f32;
        self.wet.set_temperature(Fahrenheit(fahr_temp));
    }

    fn temperature(&self) -> Celsius {
        Celsius((self.wet.temperature().0 - 32f32) / 1.8f32)
    }

    // This is only for example purposes, to show the "adapter pattern in action"
    fn weather(&self) -> Weather {
        self.wet
    }
}

fn main() {
    let mut clima = Climate::new();
    clima.set_temperature(Celsius(25f32));
    let wet = clima.weather();
    assert_eq!(clima.temperature(), Celsius(25f32));
    assert_eq!(wet.temperature(), Fahrenheit(77f32));
}
