class Computer
  attr_accessor :display, :motherboard, :drives

  def initialize(display = :crt, motherboard = Motherboard.new, drives = [])
    @display = display
    @motherboard = motherboard
    @drives = drives
  end
end

class CPU; end

class BasicCPU < CPU; end

class TurboCPU < CPU; end

class Drive
  attr_reader :type, :size, :writable

  def initialize(type, size, writable)
    @type = type
    @size = size
    @writable = writable
  end
end

class Motherboard
  attr_accessor :cpu, :memory_size

  def initialize(cpu = BasicCPU.new, memory_size = 1000)
    @cpu = cpu
    @memory_size = memory_size
  end
end

class ComputerBuilder
  attr_reader :computer

  def initialize
    @computer = Computer.new
  end

  def turbo(_has_turbo_cpu = true)
    @computer.motherboard.cpu = TurboCPU.new
  end

  def display(display)
    @computer.display = display
  end

  def memory_size(size_in_mb)
    @computer.motherboard.memory_size = size_in_mb
  end

  def add_cd(writable = false)
    @computer.drives << Drive.new(:cd, 760, writable)
  end

  def add_dvd(writable = false)
    @computer.drives << Drive.new(:dvd, 4700, writable)
  end

  def add_hard_disk(size_in_mb)
    @computer.drives << Drive.new(:hard_disk, size_in_mb, true)
  end

  def method_missing(name, *args)
    words = name.to_s.split('_')
    return super(name, *args) unless words.shift == 'add'
    words.each do |word|
      next if word == 'and'
      add_cd if word == 'cd'
      add_dvd if word == 'dvd'
      add_hard_disk(100_000) if word == 'harddisk'
      turbo if word == 'turbo'
    end
  end

  def computer
    raise 'Not enough memory.' if @computer.motherboard.memory_size < 250
    raise 'Too many drives.' if @computer.drives.size > 4
    @computer
  end
end

builder = ComputerBuilder.new
builder.turbo
builder.display(:lcd)
builder.add_cd
builder.add_dvd(true)
builder.add_hard_disk(100_000)

builder = ComputerBuilder.new
builder.memory_size(249)
begin
  builder.computer
rescue Exception => e
  puts e.message
end

builder = ComputerBuilder.new
builder.add_cd
builder.add_dvd
builder.add_hard_disk(1000)
builder.add_cd
builder.add_dvd
begin
  builder.computer
rescue Exception => e
  puts e.message
end

puts 'Computer built with magic method builder'
builder = ComputerBuilder.new
builder.add_cd_and_dvd_and_harddisk_and_turbo
computer = builder.computer
puts "CPU: #{computer.motherboard.cpu.class}"
computer.drives.each { |drive| puts "Drive: #{drive.type}" }