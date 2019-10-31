class Person
  attr_accessor :name
  
  def initialize(name:)
    @name = name
  end
end

class Guy < Person
end

class Gal < Person
end

class StereotypicProgrammer
  attr_accessor :person, :skills

  def initialize(person:, skills: [])
    @person     = person
    @skills     = skills
  end

  def skills_list
    return "none" if skills.empty?
    return "\t- " + skills.join("\n\t- ")
  end

  def bio
    <<-EOF
      #{person.name}
      His skills are:
      #{skills_list}
    EOF
  end
end

class RespectfulProgrammerAdapter
  attr_accessor :programmer

  def initialize(programmer:)
    @programmer = programmer
  end

  def bio
    bio = programmer.bio
    bio.gsub!(/His/,'Her') if programmer.person.is_a?(Gal)
    return bio
  end
end

class SoftwareBook
  def initialize(influencers: [])
    @influencers = influencers
  end

  def influencers
    @influencers.map{|i| i.bio}.join("\n")
  end
end

################
# Example usage
################

p1 = StereotypicProgrammer.new( person: Guy.new(name: 'Dennis'), skills: %w{ C UNIX })
p2 = StereotypicProgrammer.new( person: Guy.new(name: 'Mark'),   skills: %w{ PHP SocialNetwork })
p3 = StereotypicProgrammer.new( person: Gal.new(name: 'Ada'),    skills: %w{ Math Analytics})

rp1 = RespectfulProgrammerAdapter.new(programmer: p1)
rp2 = RespectfulProgrammerAdapter.new(programmer: p2)
rp3 = RespectfulProgrammerAdapter.new(programmer: p3)

book = SoftwareBook.new(influencers: [ rp1, rp2, rp3])

puts book.influencers 

