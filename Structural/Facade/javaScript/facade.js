/**
 * Created by HP on 3/5/2018.
 */
/**
 * Created by HP on 3/5/2018.
 */

class Day {

    constructor (time, duration, destination, style='as for work') {
        this.time = time;
        this.duration = duration;
        this.style = style;
        this.destination = destination;
    }

    wakeUp() {
        console.log(`Waking up at ${this.time}`);
    }

    takeShower() {
        console.log(`Taking shower for ${this.duration}`);
    }

    dressUp() {
        console.log(`Dress up ${this.style}`);
    }

    goTo() {
        console.log(`Going to ${this.destination}`)
    }

    set mood (type) {
        console.log(`Mood is ${type}`);
    }
}



class WeekDayFacade extends Day {

    constructor(time, duration, destination, style) {
        super(time, duration, destination, style);
    }

    run(){
        this.wakeUp();
        this.mood = 'working';
        this.takeShower();
        this.dressUp();
        this.goTo();
    }
}

const Monday = new WeekDayFacade('6 a.m.', '15 seconds', 'office', 'as for work');

Monday.run(); // Waking up at 6 a.m., mood is working, taking shower for 15  seconds, dress up as for work, going to office