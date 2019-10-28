class Subject
  def request
    raise NotImplementedError
  end
end

class RealSubject < Subject
  def request
    puts ' - [RealSubject] Handling request.'
  end
end

class ProxySubject < Subject
  def initialize(real_subject)
    @real_subject = real_subject
  end

  def request
    authorize
    @real_subject.request
    log
  end

  private

  def authorize
    puts ' - [Proxy] Authorizing...'
  end

  def log
    puts ' - [Proxy] Logging access...'
  end
end

class SubjectService
  def new_subject
    RealSubject.new
  end

  def new_secure_subject
    ProxySubject.new(RealSubject.new)
  end
end

service = SubjectService.new

puts 'Accessing the real subject:'
service.new_subject.request
puts

puts 'Accessing the proxy subject:'
service.new_secure_subject.request
puts