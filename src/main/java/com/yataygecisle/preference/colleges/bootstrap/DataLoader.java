package com.yataygecisle.preference.colleges.bootstrap;

import com.yataygecisle.preference.colleges.domain.*;
import com.yataygecisle.preference.colleges.domain.enums.*;
import com.yataygecisle.preference.colleges.repository.CollegeRepository;
import com.yataygecisle.preference.colleges.repository.CountryRepository;
import com.yataygecisle.preference.colleges.repository.DistrictRepository;
import com.yataygecisle.preference.colleges.repository.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.UUID;

@Profile("local")
@Slf4j
@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final ProvinceRepository provinceRepository;
    private final CollegeRepository collegeRepository;
    private final DistrictRepository districtRepository;

    @Override
    public void run(String... args) throws Exception {
        if (countryRepository.findAll().size() == 0) {
            loadInitialData();
        }
    }

    @Transactional
    private void loadInitialData() {
        Country country = new Country();
        country.setCountryId(UUID.randomUUID());
        country.setCountryName("Turkey");

        District district = new District();
        district.setDistrictId(UUID.randomUUID());
        district.setDistrictName("Besiktas");


        Province province = new Province();
        province.setProvinceId(UUID.randomUUID());
        province.setProvinceName("Istanbul");
        province.addDistrict(district);


        countryRepository.save(country);
        provinceRepository.save(province);
        districtRepository.save(district);

        Course course = new Course();
        course.setCourseCode(1L);
        course.setCourseName("Computer Science");
        course.setCourseType(CourseType.FAK);
        course.setFunderType(FunderType.PUBLIC);
        course.setEducationType(EducationType.FORMAL);
        course.setCourseFeature(CourseFeature.ENGLISH);
        course.setPointType(PointType.SAY);
        course.setMinimumPoint(492.274);
        course.setMinimumOrder(482.0);
        course.setMinimumRequiredOrder(300000.0);
        course.setNominalQuota(4);
        course.setNominalDuration(80);
        course.setRegisteredStudents(82);
        course.addCountry(country);
        course.addProvince(province);
        course.addDistrict(district);

        Faculty faculty = new Faculty();
        faculty.setFacultyName("Engineering Faculty");
        faculty.addCourse(course);

        College college = new College();
        college.setCollegeName("Bogazici Universitesi");
        college.addFaculty(faculty);
        college.addCourse(course);


        collegeRepository.save(college);


    }

}
