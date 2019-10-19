const Administration = function() {
  this.print = role => {
    return `
      ${role.toUpperCase()}
      * Diary management and arranging appointments, booking meeting rooms and conference facilities
      * Data entry (sales figures, property listings etc.)
      * General office management such as ordering stationary`;
  };
};

module.exports = Administration;
