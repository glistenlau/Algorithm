class ValidParentheses
  def is_valid(s)
    stack = []
    lookup = Hash[")", "(", "}", "{", "]", "["]
    s.each_char do |c|
      if lookup.has_key?(c)
        if stack.pop() != lookup[c]
          return false
        end
      else
        stack.push(c)
      end
    end
    return stack.empty?
  end
end

puts ValidParentheses.new().is_valid("()[]{}")
puts ValidParentheses.new().is_valid("([)]")