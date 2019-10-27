# This is a traditional example of a callback in Ruby but it is not idiomatic.
def finished_homework(subject)
  p "Finished my #{subject} homework."
end

def do_homework(subject, callback)
  p "Starting my #{subject} homework."
  callback.call(subject)
end

do_homework("Math", method(:finished_homework))

# To perform an idiomatic ruby callback, the block syntax is used
def do_homework(subject, &block)
  p "Starting my #{subject} homework."
  yield subject
end

do_homework("Math") do |subject|
  p "Finished my #{subject} homework."
end
