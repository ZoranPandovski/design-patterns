const Developer = function() {
  this.print = role => {
    return `
      ${role.toUpperCase()}
      * Producing clean, efficient code based on specifications
      * Testing and deploying programs and systems
      * Fixing and improving existing software`;
  };
};

module.exports = Developer;
