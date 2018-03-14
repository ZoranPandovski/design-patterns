/**
 * Created by HP on 3/14/2018.
 */

class Shop {
    constructor (shopName){
        this.shopName = shopName;
        this.command = [];
    }

    buy(item) {
        console.log(`Purchasing ${item} in ${this.shopName}`)
    }

    takeALook(item) {
        console.log(`Checking out ${item} in ${this.shopName}`)
    }

    returnItem(item) {
        console.log(`Returning ${item} in ${this.shopName}`)
    }

    execute(command, item) {
        return this[command].call(this, item);
    }
}

const sevenEleven = new Shop('7/11');

sevenEleven.execute('takeALook', 'iced coffee');
sevenEleven.execute('buy', 'sneekers');
sevenEleven.execute('buy', 'shower gel');
sevenEleven.execute('returnItem', 'shower gel');

