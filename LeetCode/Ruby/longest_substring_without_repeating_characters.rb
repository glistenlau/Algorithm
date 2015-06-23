class LongestSubstringWithoutRepeatingCharacters
  def length_of_longest_substring(s)
    last = 0
    lookup = Hash(nil)
    (0...s.size).each do |i|
      if lookup.has_key?(s[i]) && lookup[s[i]] + 1 > last
        @max = [i - last, @max ? @max : 0].max
        last = lookup[s[i]] + 1
      end
      lookup[s[i]] = i
    end
    [@max, s.size - last].max

  end
end

puts LongestSubstringWithoutRepeatingCharacters.new
         .length_of_longest_substring("abba")