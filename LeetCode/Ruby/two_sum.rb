class TwoSum
  def two_sum(nums, target)
    lookup = {}
    nums.each_with_index do |val, index|
      if lookup.has_key?(target - val)
        return lookup[target - val] + 1, index + 1
      else
        lookup[val] = index
      end
    end
  end
end

puts TwoSum.new.two_sum([2, 7, 11, 15], 9)