class MaximumProductSubarrary
  def max_product(nums)
    if nums.size == 0
      return 0
    end
    nums.each do |num|
      mx = @max ? @max * num : num
      mn = @min ? @min * num : num

      @max = @max ? [[mx, num].max, mn].max : num
      @min = @min ? [[mn, num].min, mx].min : num
      @maxAns = @maxAns ? [@maxAns, @max].max : @max
    end
    @maxAns
  end

  if __FILE__ == $0
    test = MaximumProductSubarrary.new
    puts test.max_product([-2])
    puts test.max_product([-4, -3])
  end
end

