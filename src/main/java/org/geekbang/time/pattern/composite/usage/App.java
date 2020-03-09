package org.geekbang.time.pattern.composite.usage;

import java.util.List;

public class App {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    private DepartmentRepo departmentRepo;
    private EmployeeRepo employeeRepo;

    public void buildOrganization() {
        Department department = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(department);
    }

    private void buildOrganization(Department department) {
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }


    private interface DepartmentRepo {

        /** 获取子部门节点列表 */
        List<Long> getSubDepartmentIds(long departmentId);
    }

    private interface EmployeeRepo {

        /** 获取部门的员工列表 */
        List<Long> getDepartmentEmployeeIds(long departmentId);

        /** 查询员工的薪水 */
        double getEmployeeSalary(Long employeeId);

    }
}
