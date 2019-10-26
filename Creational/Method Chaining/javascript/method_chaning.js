class Story {
  constructor() {
    this.story = "";
  }

  setAuthor(author) {
    this.auhtor = author;

    return this;
  }

  setTitle(title) {
    this.title = title;

    return this;
  }

  appendStory(story) {
    this.story += story;

    return this;
  }

  setDate(date) {
    this.date = date;

    return this;
  }

  print() {
    console.log(`
      Written on ${this.date.toLocaleDateString()},

      "${this.title}" written by ${this.auhtor},

      ${this.story}

      The End.
    `);
  }
}

new Story()
  .setAuthor("yuko")
  .setDate(new Date())
  .setTitle("Award-Winning Story With A Twist")
  .appendStory("Jake woke up in the morning and took a look around. ")
  .appendStory("He was feeling weird yet he recognized the feeling. ")
  .appendStory("Once again he was being used in a design pattern example.")
  .print();

// Output:
// Written on 10/25/2019,
//
// "Award-Winning Story With A Twist" written by yuko,
//
// Jake woke up in the morning and took a look around. He was feeling weird yet he recognized the feeling. Once again he was being used in a design pattern example.
//
// The End.
