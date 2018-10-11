use std::ops;

#[derive(Clone, Copy, Debug, PartialEq)]
pub struct SquareMeter(u32);

impl ops::Add for SquareMeter {
    type Output = SquareMeter;

    fn add(self, other: SquareMeter) -> Self::Output {
        SquareMeter(self.0 + other.0)
    }
}

pub struct House {
    windows: u32,
    doors: u32,
    rooms: u32,
    bathrooms: u32,
    size: SquareMeter,
    garage: bool,
    kitchen: bool,
}

impl House {
    /// Returns house window count
    fn windows(&self) -> u32 {
        self.windows
    }

    /// Returns house door count
    fn doors(&self) -> u32 {
        self.doors
    }

    /// Returns house room count
    fn rooms(&self) -> u32 {
        self.rooms
    }

    /// Returns house bathroom count
    fn bathrooms(&self) -> u32 {
        self.bathrooms
    }

    /// Returns house size count in square meters
    fn size(&self) -> SquareMeter {
        self.size
    }

    /// Returns 'true' if the house has a garage, otherwise returns 'false'
    fn garage(&self) -> bool {
        self.garage
    }

    /// Returns 'true' if the house has a kitchen, otherwise returns 'false'
    fn kitchen(&self) -> bool {
        self.kitchen
    }
}

#[derive(Clone, Copy)]
pub struct HouseBuilder {
    windows: Option<u32>,
    doors: Option<u32>,
    rooms: Option<u32>,
    bathrooms: Option<u32>,
    size: Option<SquareMeter>,
    garage: Option<bool>,
    kitchen: Option<bool>,
}

impl HouseBuilder {
    /// Starts the creation of a new house
    fn new() -> HouseBuilder {
        HouseBuilder {
            windows: None,
            doors: None,
            rooms: None,
            bathrooms: None,
            size: None,
            garage: None,
            kitchen: None,
        }
    }

    /// Adds a single room to the house
    fn room(
        &mut self,
        door_count: u32,
        window_count: u32,
        room_size: SquareMeter,
    ) -> &mut HouseBuilder {
        if let (Some(room_value), Some(door_value), Some(window_value), Some(size_value)) =
            (self.rooms, self.doors, self.windows, self.size)
        {
            self.rooms = Some(room_value + 1);
            self.doors = Some(door_value + door_count);
            self.windows = Some(window_value + window_count);
            self.size = Some(size_value + room_size);
        } else {
            self.rooms = Some(1);
            self.doors = Some(door_count);
            self.windows = Some(window_count);
            self.size = Some(room_size);
        }
        self
    }

    /// Adds a single bathroom to the house
    fn bathroom(&mut self, bathroom_size: SquareMeter) -> &mut HouseBuilder {
        if let (Some(bathroom_value), Some(size_value)) = (self.bathrooms, self.size) {
            self.bathrooms = Some(bathroom_value + 1);
            self.size = Some(size_value + bathroom_size);
        } else {
            if let Some(size_value) = self.size {
                self.size = Some(size_value + bathroom_size);
            } else {
                self.size = Some(bathroom_size)
            }
            self.bathrooms = Some(1);
        }
        self
    }

    /// Defines if the house has a garage
    fn garage(&mut self, garage: bool, garage_size: SquareMeter) -> &mut HouseBuilder {
        if let Some(size_value) = self.size {
            self.size = Some(size_value + garage_size);
        } else {
            self.size = Some(garage_size);
        }
        self.garage = Some(garage);
        self
    }

    /// Defines if the house has a kitchen
    fn kitchen(&mut self, kitchen: bool, kitchen_size: SquareMeter) -> &mut HouseBuilder {
        if let Some(size_value) = self.size {
            self.size = Some(size_value + kitchen_size);
        } else {
            self.size = Some(kitchen_size);
        }
        self.kitchen = Some(kitchen);
        self
    }

    /// Adds more windows to the house
    ///
    /// Note: this function does not replace windows already placed by rooms,
    /// it simply adds more to the window count of the house.
    fn windows(&mut self, window_count: u32) -> &mut HouseBuilder {
        if let Some(window_value) = self.windows {
            self.windows = Some(window_value + window_count);
        } else {
            self.windows = Some(window_count);
        }
        self
    }

    /// Adds more doors to the house
    ///
    /// Note: this function does not replace doors already placed by rooms,
    /// it simply adds more to the door count of the house.
    fn doors(&mut self, door_count: u32) -> &mut HouseBuilder {
        if let Some(door_value) = self.doors {
            self.doors = Some(door_value + door_count);
        } else {
            self.doors = Some(door_count);
        }
        self
    }

    /// Build the house
    ///
    /// # Panics
    ///
    /// This function will panic if any of the properties of the house are
    /// missing (i.e.: set to None), with an error message indicating which
    /// property has not been set.
    fn build(self) -> House {
        House {
            windows: self
                .windows
                .expect("Could not build the house: windows are missing!"),
            doors: self
                .doors
                .expect("Could not build the house: doors are missing!"),
            rooms: self
                .rooms
                .expect("Could not build the house: rooms are missing!"),
            bathrooms: self
                .bathrooms
                .expect("Could not build the house: bathrooms are missing!"),
            size: self
                .size
                .expect("Could not build the house: size is missing!"),
            garage: self
                .garage
                .expect("Could not build the house: garage is not set!"),
            kitchen: self
                .kitchen
                .expect("Could not build the house: kitchen is not set!"),
        }
    }
}

fn main() {
    let home: House = HouseBuilder::new()
        .room(1, 2, SquareMeter(4))
        .room(1, 2, SquareMeter(6))
        .bathroom(SquareMeter(3))
        .bathroom(SquareMeter(3))
        .garage(false, SquareMeter(0))
        .kitchen(true, SquareMeter(4))
        .build();
    assert_eq!(home.windows(), 4);
    assert_eq!(home.rooms(), 2);
    assert_eq!(home.size(), SquareMeter(20));
    assert!(home.garage() == false);
    assert!(home.kitchen() == true);
}
