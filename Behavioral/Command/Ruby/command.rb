class Switch
  attr_reader :history

  def execute(cmd)
    @history ||= []
    @history << cmd.execute
  end
end

class Command
  attr_reader :light

  def initialize(light)
    @light = light
  end

  def execute
    raise NotImplementedError
  end
end

class TurnOnCommand < Command
  def execute
    light.turn_on
  end
end

class TurnOffCommand < Command
  def execute
    light.turn_off
  end
end

class Light
  def turn_on
    'the light is on'
  end

  def turn_off
    'the light is off'
  end
end

class LightSwitchClient
  attr_reader :switch

  def initialize
    @lamp = Light.new
    @switch = Switch.new
  end

  def switch_for(cmd)
    case cmd
      when 'on'  then @switch.execute(TurnOnCommand.new(@lamp))
      when 'off' then @switch.execute(TurnOffCommand.new(@lamp))
    else
      puts 'Sorry, I so sorry'
    end
  end
end

client = LightSwitchClient.new

puts client.switch_for('on')
puts client.switch_for('off')

puts ''
puts '>>> History'

puts client.switch.history
