__author__ = 'YiLIU'


class Solution(object):
    def grounds_not_filled(self, grounds, springs):
        ground_has_spring = dict()
        for spring in springs:
            ground_has_spring[spring] = True

        left_stack = list()
        for index in range(len(grounds)):
            if ground_has_spring.get(index):
                while len(left_stack) != 0 and grounds[index] > grounds[left_stack[-1]]:
                    left_stack.pop()
            left_stack.append(index)

        right_stack = list()
        for index in range(len(grounds)):
            if ground_has_spring.get(index):
                while len(right_stack) != 0 and grounds[index] > grounds[right_stack[-1]]:
                    right_stack.pop()
            right_stack.append(index)

        has_no_spring = set(left_stack)
        has_no_spring.intersection_update(right_stack)

        for s in springs:
            has_no_spring.remove(s)

        return list(has_no_spring)


print(Solution().grounds_not_filled([2, 0, 1, 2], [2]))
