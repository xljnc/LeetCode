package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 * https://leetcode-cn.com/problems/employee-importance/
 *
 * @author 一贫
 * @date 2021/5/1
 */
public class Problem690 {

    private Map<Integer, Employee> map = new HashMap<>();
    private int count = 0;

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Employee employee = map.get(id);
        calc(employee);
        return count;
    }

    private void calc(Employee employee) {
        count += employee.importance;
        for (int i : employee.subordinates) {
            calc(map.get(i));
        }
    }


    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
