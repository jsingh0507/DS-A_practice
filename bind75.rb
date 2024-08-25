def merge_alternately(word1, word2)
    res=""
    if word2.length > word1.length
        long = word2
    else
        long = word1
    end

    (0...long.length).each do |i|
        if word1[i]!=nil
            res+=word1[i]
        end
        
        if word2[i]!=nil
            res+=word2[i]
        end
    end
    return res
end

def can_place_flowers(flowerbed, n)
    return true if n==0
    i = 0 

    while (i<flowerbed.length)
        if flowerbed[i]==1
            i+=2
        elsif flowerbed[i]==0
            if flowerbed[i+1]==0 || i== flowerbed.length-1
                n-=1
                i+=2
            elsif flowerbed[i+1] == 1
                i+=3
            end
        end
        return true if n==0
    end
    return false
end

#in java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int k=0;
        int j=0;
        for(i=1;i<nums.length;i++){
            if(nums[k]!=nums[i]){
                k++;
                nums[k]=nums[i];
            }
        }
        return k+1;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==2){
            return nums.length;
        }
        int k=2;
        int i=2;
        for(i=2;i<nums.length;i++){
            if(nums[i]!=nums[k-2]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}

#gourp anagram with ruby

def group_anagrams(strs)
    hash =  Hash.new { |hash, key| hash[key] = [] }

    strs.each do |word|
        hash[word.split("").sort.join("")]<<word
    end

    return hash.values
end

def divide(dividend, divisor)
   # 0 <= r < b and a = b * q + r
   return 1 if dividend == divisor

   max_int = 2147483647
   is_positive = (dividend < 0 == divisor < 0)
   a = dividend.abs
   b = divisor.abs
   result = 0

   while(a >= b)
     q = 0

     while(a > (b << (q + 1)))
       q += 1
     end

     result += (1 << q)
     a = a - (b << q)
   end

   result = if (result > max_int && is_positive)
           max_int
         else
           result
         end

   is_positive ? result : -1 * result
end

def is_valid(s)
    brackets = []
    
    s.chars.each do |c|
        if c == '(' || c == '{' || c == '['
            brackets.push(c)
        else
            if brackets.empty?
                return false  # There's no matching open bracket.
            end
            
            open_bracket = brackets.pop
            
            if (c == ')' && open_bracket != '(') || (c == '}' && open_bracket != '{') || (c == ']' && open_bracket != '[')
                return false  # Mismatched closing bracket.
            end
        end
    end
    
    brackets.empty?  # All open brackets should be closed.
end

# sustring with no repeated chars using set

def length_of_longest_substring(s)
    return 0 if s.empty?
    return 0 if s.empty?

  char_set = Set.new
  left = 0
  max_length = 0

  s.each_char.with_index do |char, right|
    while char_set.include?(char)
      char_set.delete(s[left])
      left += 1
    end
    char_set.add(char)
    max_length = [max_length, char_set.length].max
  end

  max_length
end

# Integer to roman
def int_to_roman(num)
    alphas = %w[I IV V IX X XL L XC C CD D CM M]
    alpha_values = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
    ans = ""
    alphas.zip(alpha_values).reverse.each_with_index do |alpha_value, index|
      while num >= alpha_value[1]
        ans << alpha_value[0]
        num -= alpha_value[1]
      end
    end
    ans
end

#letter combination
def letter_combinations(digits)
    return [] if digits.empty?

    phone_map = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    output = []

    def backtrack(combination, next_digits, phone_map, output)
        if next_digits.empty?
            output << combination
        else
            letters = phone_map[next_digits[0].to_i - 2]
            letters.each_char do |letter|
                backtrack(combination + letter, next_digits[1..], phone_map, output)
            end
        end
    end

    backtrack("", digits, phone_map, output)
    output
end

#set-matrix-zeros
def set_zeroes(matrix)
    first_row_zero = false
    first_column_zero = false

    matrix.first.size.times do |j|
        first_row_zero = true if matrix[0][j] == 0
    end

    matrix.size.times do |i|
        first_column_zero = true if matrix[i][0] == 0
    end

    # check for rest of the matrix for zeros
    # store the zeros in the first row and first columns
    1.upto(matrix.size - 1) do |i|
        1.upto(matrix.first.size - 1) do |j|
            if matrix[i][j] == 0
                matrix[0][j] = 0
                matrix[i][0] = 0
            end
        end
    end

    # set rows zero if first column has zero in its cell
    1.upto(matrix.size - 1) do |i|
        if matrix[i][0] == 0
            matrix[i].map!{0}
        end
    end

    # set columns zero if first row has zero in its cell
    1.upto(matrix.first.size - 1) do |j|
        if matrix[0][j] == 0
            1.upto(matrix.size - 1) do |i|
                matrix[i][j] = 0
            end
        end
    end

    # if first row was having zero before
    if first_row_zero
        matrix[0].map!{0}
    end

    if first_column_zero
        0.upto(matrix.size - 1) do |i|
            matrix[i][0] = 0
        end
    end

    matrix
end

#word-break
def word_break(s, word_dict)
    queue = [s]
    h = Hash.new(false)
    while queue.length > 0
        word = queue.shift
        next if h[word]
        return true if word == "" || word == nil
        h[word] = true
        word_dict.each do |w|
            if word.start_with?(w)
                queue.push(word[w.length..])
            end
        end
    end
    return false
end

#group_anagram refactored with hash
def group_anagrams(strs)
    group = Hash.new {|key, val| key[val]=[]}

    strs.each do |word|
        group[word.chars.sort.join] << word
    end

    return group.values
end

#top k frequen element with hash O(n)

def top_k_frequent(nums, k)
    hash = Hash.new {|h,k| h[k]=0}

    nums.each do |num|
        hash[num]+=1
    end

    res = hash.sort_by {|k,v| v}.reverse
    ans = []
    i=0
    while k>0
        ans << res[i][0]
        i+=1
        k-=1
    end
    return ans
end

#product expcet itself exceeding time limit trying to find better solution with same approach but different usage
def product_except_self(nums)
    hash = {}
    res = []
    nums.each.with_index do |val, i|
        hash[i]=val
    end
    i=0
    res =[]
    while i<nums.length
        prod = 1
        hash.each do |h,k|
            if i!=h
                prod*=k
            end
        end
        res << prod
        i+=1
    end 
    return res
end

#longest consecutive sequence ex. 1,2,3,4 from [1,10,2,3,9,4]

def longest_consecutive(nums)
    return 0 if nums.length == 0

    nums = nums.sort

    result = counter = 0

    for i in 0...nums.length
        next if nums[i + 1] == nums[i]
        if (nums[i] + 1) == nums[i+1]
            counter += 1
        else
            result =  counter + 1 if result < (counter + 1)
            counter = 0
        end
    end

    result
end

#is_palindrome still working on it 
def is_palindrome(s)
    f = s.split(",").join("")
    r = f.split(" ").join("")
    if r.upcase == r.upcase.reverse
        return true
    else 
        return false
    end
end

#valid parenthesis using stack and cases
def is_valid(s)
    return true if s.empty?
    
    stack = []
    s.each_char do |c|
        case c
        when '(', '{', '['
            stack.push(c)
        when ')'
            return false if stack.pop() != '('
        when '}'
            return false if stack.pop() != '{'
        when ']'
            return false if stack.pop() != '['
        end
    end
    return stack.empty?
end

#binary search used to find min value rotated array

def find_min(nums)
    n = nums.length
    left = 0
    right = n - 1
    min = nums[0]

    while left <= right
        # if the array is sorted and not rotated
        if nums[left] < nums[right]
            min = [min, nums[left]].min
            break
        end

        mid = (left + right) / 2
        min = [min, nums[mid]].min

        # left sorted portion
        if nums[mid] >= nums[left] # equal to because mid could be the left
            left = mid + 1 # smaller values will be on the right after rotation
        else
            right = mid - 1
        end
    end
    min
end

#number of island using tree, used the solution as I was stuck in the problem will try to solve same problem next week
def dfs(grid, i, j)
    n = grid.length
    m = grid[0].length
    
    if i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1'
        return
    end
    
    grid[i][j] = '2' # Mark as visited
    
    # Explore neighbors
    dfs(grid, i+1, j) # Check bottom
    dfs(grid, i-1, j) # Check top
    dfs(grid, i, j+1) # Check right
    dfs(grid, i, j-1) # Check left
end

def num_islands(grid)
    count = 0
    n = grid.length
    m = grid[0].length
    
    for i in 0...n
        for j in 0...m
            if grid[i][j] == '1'
                count += 1
                dfs(grid, i, j)
            end
        end
    end
    return count
end
#search in rotated array using binary search tree
def search(nums, target)
    return -1 if nums.empty?
    
    left = 0
    right = nums.size - 1
    while left <= right
        mid = (left + right) / 2
        if nums[mid] == target
            return mid
        end
        if nums[mid] >= nums[left]
            if target >= nums[left] && target < nums[mid]
                right = mid - 1
            else
                left = mid + 1
            end
        else
            if target <= nums[right] && target > nums[mid]
                left = mid + 1
            else
                right = mid - 1
            end
        end
    end
    -1
end

#reverse linked list 

def reverse_list(head)
    prev = nil
    temp = nil
    while head do
        prev = head
        head = head.next
        prev.next = temp
        temp = prev
    end
    prev
end