package com.student.careerlearning.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.student.careerlearning.model.CareerCourse;
import com.student.careerlearning.repository.CareerCourseRepository;

@Component
public class CareerCourseDataLoader implements CommandLineRunner {

    private final CareerCourseRepository careerCourseRepository;

    public CareerCourseDataLoader(
            CareerCourseRepository careerCourseRepository) {

        this.careerCourseRepository = careerCourseRepository;
    }

    @Override
    public void run(String... args) {

        // Do not insert duplicate data
        if (careerCourseRepository.count() > 0) {
            return;
        }

        List<CareerCourse> courses = List.of(

                // =====================================================
                // SCIENCE - PCM
                // =====================================================

                createCourse(
                        "Science",
                        "PCM",
                        "B.Tech CSE",
                        "4 Years",
                        "10+2 with required marks and PCM subjects",
                        "Physics, Chemistry, Mathematics",
                        "Computer Science and Engineering focuses on programming, software, computers and technology.",
                        "Programming, Data Structures, Database, Operating Systems, Computer Networks",
                        "Programming, Problem Solving, Logical Thinking, Communication",
                        "Software Engineer, Software Developer, Web Developer, Backend Developer",
                        "Software Developer, Web Developer, Backend Developer",
                        "M.Tech, MCA, MBA, Specialized Certifications",
                        "JEE Main and other applicable entrance examinations",
                        "Admission may be through entrance examination, counselling or institute-level admission.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Science",
                        "PCM",
                        "B.Tech AI/ML",
                        "4 Years",
                        "10+2 with required marks and PCM subjects",
                        "Physics, Chemistry, Mathematics",
                        "B.Tech in Artificial Intelligence and Machine Learning focuses on AI, machine learning and intelligent systems.",
                        "Artificial Intelligence, Machine Learning, Python, Mathematics, Data Science",
                        "Programming, Mathematics, Problem Solving, Analytical Thinking",
                        "AI Engineer, Machine Learning Engineer, Data-related roles",
                        "AI Engineer, ML Engineer, Data Analyst",
                        "M.Tech, MS, MBA, Specialized AI/ML Certifications",
                        "JEE Main and other applicable entrance examinations",
                        "Admission depends on the institute and applicable entrance/counselling process.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Science",
                        "PCM",
                        "B.Tech Data Science",
                        "4 Years",
                        "10+2 with required marks and PCM subjects",
                        "Physics, Chemistry, Mathematics",
                        "Data Science combines programming, statistics and data analysis to solve real-world problems.",
                        "Statistics, Python, Data Analysis, Machine Learning, Database",
                        "Programming, Mathematics, Statistics, Analytical Thinking",
                        "Data Scientist, Data Analyst, Data Engineer",
                        "Data Analyst, Data Scientist, Data Engineer",
                        "M.Tech, MS, MBA, Data Science Certifications",
                        "JEE Main and other applicable entrance examinations",
                        "Admission depends on the institute and applicable entrance/counselling process.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Science",
                        "PCM",
                        "B.Tech Cyber Security",
                        "4 Years",
                        "10+2 with required marks and PCM subjects",
                        "Physics, Chemistry, Mathematics",
                        "Cyber Security focuses on protecting computers, networks, applications and data.",
                        "Networking, Operating Systems, Cyber Security, Cryptography, Ethical Security",
                        "Problem Solving, Networking, Logical Thinking, Programming",
                        "Cyber Security Analyst, Security Engineer, Security Specialist",
                        "Cyber Security Analyst, Security Engineer, Security Administrator",
                        "M.Tech, MS, Cyber Security Certifications",
                        "JEE Main and other applicable entrance examinations",
                        "Admission depends on the institute and applicable entrance/counselling process.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Science",
                        "PCM",
                        "B.Arch",
                        "5 Years",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Physics, Chemistry, Mathematics",
                        "Bachelor of Architecture focuses on architectural design, planning and construction concepts.",
                        "Architectural Design, Building Construction, Drawing, Planning",
                        "Creativity, Drawing, Design Thinking, Spatial Understanding",
                        "Architect, Architectural Designer, Planning Professional",
                        "Architect, Architectural Designer, Interior-related roles",
                        "M.Arch, MBA, Specialized Design Studies",
                        "Applicable architecture entrance examinations",
                        "Admission depends on institute and applicable counselling process.",
                        "Salary varies according to skills, experience and organization."
                ),

                createCourse(
                        "Science",
                        "PCM",
                        "B.Sc Mathematics",
                        "3 Years",
                        "10+2 with Mathematics and applicable eligibility requirements",
                        "Mathematics",
                        "B.Sc Mathematics develops mathematical and analytical knowledge.",
                        "Calculus, Algebra, Statistics, Geometry, Mathematical Methods",
                        "Mathematical Thinking, Problem Solving, Analytical Skills",
                        "Data Analyst, Teacher, Research-related roles",
                        "Data Analyst, Teacher, Research Assistant",
                        "M.Sc Mathematics, MCA, B.Ed, Research Studies",
                        "Institute/university-specific admission or entrance process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Science",
                        "PCM",
                        "B.Sc Physics",
                        "3 Years",
                        "10+2 with Physics and applicable eligibility requirements",
                        "Physics, Mathematics",
                        "B.Sc Physics develops knowledge of physical laws, experiments and mathematical applications.",
                        "Mechanics, Electricity, Optics, Thermodynamics, Electronics",
                        "Mathematical Skills, Analytical Thinking, Problem Solving",
                        "Researcher, Teacher, Technical Professional",
                        "Research Assistant, Teacher, Technical Assistant",
                        "M.Sc Physics, B.Ed, Research Studies",
                        "Institute/university-specific admission or entrance process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                // =====================================================
                // SCIENCE - PCB
                // =====================================================

                createCourse(
                        "Science",
                        "PCB",
                        "MBBS",
                        "5.5 Years including internship",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Physics, Chemistry, Biology",
                        "MBBS is a medical degree focused on human health, disease diagnosis and treatment.",
                        "Anatomy, Physiology, Biochemistry, Pathology, Pharmacology, Medicine",
                        "Communication, Scientific Thinking, Responsibility, Learning Skills",
                        "Doctor, Medical Professional",
                        "Medical Doctor after completing required education and registration",
                        "Postgraduate Medical Studies and Specialization",
                        "NEET-UG and applicable admission process",
                        "Admission is subject to applicable medical admission rules and counselling.",
                        "Income varies widely by specialization, location, sector and experience."
                ),

                createCourse(
                        "Science",
                        "PCB",
                        "BDS",
                        "5 Years including internship",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Physics, Chemistry, Biology",
                        "BDS focuses on oral health, dental diagnosis and dental treatment.",
                        "Dental Anatomy, Oral Pathology, Dental Surgery, Prosthodontics",
                        "Communication, Precision, Scientific Thinking, Manual Skills",
                        "Dentist, Dental Professional",
                        "Dentist after completing required education and registration",
                        "MDS and Dental Specializations",
                        "NEET-UG and applicable admission process",
                        "Admission is subject to applicable dental admission rules and counselling.",
                        "Income varies by specialization, location, practice and experience."
                ),

                createCourse(
                        "Science",
                        "PCB",
                        "B.Pharm",
                        "4 Years",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Physics, Chemistry, Biology/Mathematics",
                        "B.Pharm focuses on medicines, pharmaceutical science and drug-related knowledge.",
                        "Pharmaceutics, Pharmacology, Pharmaceutical Chemistry, Pharmacognosy",
                        "Scientific Thinking, Accuracy, Communication, Laboratory Skills",
                        "Pharmacist, Pharmaceutical Professional",
                        "Pharmacist, Quality Control, Pharmaceutical Industry roles",
                        "M.Pharm, MBA, Pharmaceutical Certifications",
                        "Institute/university-specific admission or applicable entrance process",
                        "Admission depends on institute and applicable admission rules.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Science",
                        "PCB",
                        "B.Sc Nursing",
                        "4 Years",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Physics, Chemistry, Biology",
                        "B.Sc Nursing prepares students for professional nursing and healthcare services.",
                        "Nursing Foundations, Anatomy, Physiology, Medical-Surgical Nursing",
                        "Communication, Patient Care, Teamwork, Responsibility",
                        "Nurse, Healthcare Professional",
                        "Staff Nurse, Nursing Officer, Healthcare roles",
                        "M.Sc Nursing, Specialized Nursing Studies",
                        "Applicable nursing entrance/admission process",
                        "Admission depends on the institution and applicable rules.",
                        "Salary varies according to role, organization, location and experience."
                ),

                createCourse(
                        "Science",
                        "PCB",
                        "BPT",
                        "4.5 Years including applicable internship",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Physics, Chemistry, Biology",
                        "BPT focuses on physical rehabilitation, movement and physiotherapy.",
                        "Anatomy, Physiology, Exercise Therapy, Electrotherapy",
                        "Communication, Patient Care, Practical Skills, Observation",
                        "Physiotherapist, Rehabilitation Professional",
                        "Physiotherapist, Rehabilitation Assistant",
                        "MPT and Specialized Physiotherapy Studies",
                        "Institute/university-specific admission process",
                        "Admission depends on institution and applicable rules.",
                        "Salary varies according to location, role and experience."
                ),

                createCourse(
                        "Science",
                        "PCB",
                        "B.Sc Biotechnology",
                        "3 Years",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Biology, Chemistry",
                        "Biotechnology applies biological science to research, healthcare, agriculture and industry.",
                        "Cell Biology, Genetics, Microbiology, Molecular Biology",
                        "Laboratory Skills, Scientific Thinking, Research Skills",
                        "Biotechnologist, Laboratory Professional, Research Assistant",
                        "Laboratory Assistant, Research Assistant, Biotechnology roles",
                        "M.Sc Biotechnology, Research Studies",
                        "Institute/university-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, sector and experience."
                ),

                // =====================================================
                // SCIENCE - PCMB
                // =====================================================

                createCourse(
                        "Science",
                        "PCMB",
                        "B.Tech CSE",
                        "4 Years",
                        "10+2 with required marks and applicable PCM eligibility",
                        "Physics, Chemistry, Mathematics, Biology",
                        "Computer Science and Engineering focuses on software, programming and computer technology.",
                        "Programming, Data Structures, Database, Networks, Operating Systems",
                        "Programming, Problem Solving, Logical Thinking",
                        "Software Engineer, Software Developer, Web Developer",
                        "Software Developer, Web Developer, Backend Developer",
                        "M.Tech, MCA, MBA, Specialized Certifications",
                        "JEE Main and other applicable entrance examinations",
                        "Admission depends on institute and applicable counselling process.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Science",
                        "PCMB",
                        "MBBS",
                        "5.5 Years including internship",
                        "10+2 with required subjects and applicable eligibility requirements",
                        "Physics, Chemistry, Mathematics, Biology",
                        "MBBS is a medical degree focused on human health and medical practice.",
                        "Anatomy, Physiology, Biochemistry, Pathology, Medicine",
                        "Scientific Thinking, Communication, Responsibility",
                        "Doctor, Medical Professional",
                        "Medical Doctor after completing required education and registration",
                        "Postgraduate Medical Studies and Specialization",
                        "NEET-UG and applicable admission process",
                        "Admission is subject to applicable medical admission rules and counselling.",
                        "Income varies widely by specialization, location, sector and experience."
                ),

                createCourse(
                        "Science",
                        "PCMB",
                        "B.Tech Biotechnology",
                        "4 Years",
                        "10+2 with applicable eligibility requirements",
                        "Physics, Chemistry, Mathematics, Biology",
                        "B.Tech Biotechnology combines engineering principles with biological sciences.",
                        "Biotechnology, Genetics, Microbiology, Bioprocess Engineering",
                        "Research Skills, Laboratory Skills, Analytical Thinking",
                        "Biotechnologist, Research Professional, Biotechnology Engineer",
                        "Research Assistant, Biotechnology Professional",
                        "M.Tech, MS, Research Studies",
                        "Institute/university-specific admission or applicable entrance process",
                        "Admission depends on institute and applicable counselling process.",
                        "Salary varies according to role, sector and experience."
                ),

                // =====================================================
                // COMMERCE
                // =====================================================

                createCourse(
                        "Commerce",
                        "Commerce",
                        "B.Com",
                        "3-4 Years",
                        "10+2 from a recognized board with applicable eligibility",
                        "Commerce subjects; Mathematics may be required/preferred by some institutions",
                        "B.Com develops knowledge of accounting, finance, business and commerce.",
                        "Accounting, Business Law, Economics, Finance, Taxation",
                        "Numerical Skills, Communication, Analytical Thinking",
                        "Accountant, Finance Professional, Banking Professional",
                        "Accountant, Finance Assistant, Banking roles",
                        "M.Com, MBA, CA, CS, CMA",
                        "University/institute-specific admission process",
                        "Admission depends on the college or university.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Commerce",
                        "Commerce",
                        "BBA",
                        "3-4 Years",
                        "10+2 with applicable eligibility",
                        "Commerce/Business-related subjects may be helpful",
                        "BBA focuses on business, management, marketing and organizational skills.",
                        "Management, Marketing, Finance, Human Resources, Business Communication",
                        "Communication, Leadership, Problem Solving, Teamwork",
                        "Business Manager, Marketing Professional, HR Professional",
                        "Management Trainee, Marketing Executive, HR roles",
                        "MBA, Specialized Management Studies",
                        "Institute/university-specific entrance or admission process",
                        "Admission depends on institution and applicable rules.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Commerce",
                        "Commerce + Mathematics",
                        "Economics",
                        "3-4 Years",
                        "10+2 with applicable eligibility requirements",
                        "Economics, Mathematics where required",
                        "Economics studies markets, finance, policies and economic systems.",
                        "Microeconomics, Macroeconomics, Statistics, Econometrics",
                        "Mathematics, Statistics, Analytical Thinking",
                        "Economist, Data Analyst, Financial Analyst",
                        "Research Assistant, Data Analyst, Financial roles",
                        "M.A Economics, MBA, Research Studies",
                        "University/institute-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Commerce",
                        "Commerce",
                        "CA",
                        "Varies by stages and completion",
                        "Eligibility depends on the applicable ICAI route",
                        "Commerce subjects are helpful but eligibility follows the official route",
                        "Chartered Accountancy focuses on accounting, auditing, taxation and finance.",
                        "Accounting, Auditing, Taxation, Financial Management",
                        "Numerical Skills, Analytical Thinking, Discipline",
                        "Chartered Accountant, Auditor, Tax Professional",
                        "Auditor, Tax Consultant, Finance Professional",
                        "Advanced professional and specialization opportunities",
                        "ICAI examinations and applicable registration process",
                        "Follow the current official ICAI eligibility, registration and examination rules.",
                        "Income varies significantly by role, practice, organization and experience."
                ),

                createCourse(
                        "Commerce",
                        "Commerce",
                        "CS",
                        "Varies by stages and completion",
                        "Eligibility depends on the applicable ICSI route",
                        "Commerce subjects can be useful",
                        "Company Secretary studies corporate law, governance and compliance.",
                        "Company Law, Corporate Governance, Compliance, Business Law",
                        "Communication, Legal Understanding, Analytical Skills",
                        "Company Secretary, Compliance Professional",
                        "Company Secretary, Compliance Executive",
                        "Advanced corporate and legal studies",
                        "ICSI examinations and applicable registration process",
                        "Follow the current official ICSI eligibility, registration and examination rules.",
                        "Income varies according to role, organization and experience."
                ),

                createCourse(
                        "Commerce",
                        "Commerce",
                        "CMA",
                        "Varies by stages and completion",
                        "Eligibility depends on the applicable professional route",
                        "Commerce subjects are helpful",
                        "Cost and Management Accountancy focuses on cost, finance and management accounting.",
                        "Cost Accounting, Financial Management, Taxation, Management Accounting",
                        "Numerical Skills, Analytical Thinking, Financial Understanding",
                        "Cost Accountant, Finance Professional",
                        "Cost Accountant, Financial Analyst, Management Accounting roles",
                        "Advanced professional studies",
                        "Applicable professional institute examinations",
                        "Follow the current official eligibility, registration and examination rules.",
                        "Income varies according to role, organization and experience."
                ),

                // =====================================================
                // ARTS / HUMANITIES
                // =====================================================

                createCourse(
                        "Arts",
                        "Arts",
                        "BA",
                        "3-4 Years",
                        "10+2 from a recognized board with applicable eligibility",
                        "Depends on selected BA subject",
                        "BA provides broad study in humanities, social sciences and related subjects.",
                        "History, Political Science, Sociology, Geography, Languages",
                        "Communication, Critical Thinking, Research Skills",
                        "Teacher, Writer, Social Sector Professional, Administrative roles",
                        "Teacher after required qualification, Writer, Research Assistant",
                        "MA, B.Ed, MBA, Competitive Exam Preparation",
                        "University/institute-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Arts",
                        "Arts",
                        "BA English",
                        "3-4 Years",
                        "10+2 with applicable eligibility",
                        "English",
                        "BA English develops language, literature, communication and writing skills.",
                        "English Literature, Language, Writing, Communication",
                        "Communication, Writing, Critical Thinking",
                        "Teacher, Writer, Content Professional, Editor",
                        "Content Writer, Editor, Teacher after required qualification",
                        "MA English, B.Ed, Journalism, Specialized Writing Studies",
                        "University/institute-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Arts",
                        "Arts",
                        "BA Political Science",
                        "3-4 Years",
                        "10+2 with applicable eligibility",
                        "Political Science",
                        "BA Political Science studies government, political systems, public policy and society.",
                        "Political Theory, Indian Government, International Relations, Public Policy",
                        "Research, Communication, Critical Thinking",
                        "Teacher, Researcher, Policy-related Professional",
                        "Research Assistant, Teacher after required qualification, Policy roles",
                        "MA Political Science, Public Policy, Law, B.Ed",
                        "University/institute-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Arts",
                        "Arts",
                        "BA History",
                        "3-4 Years",
                        "10+2 with applicable eligibility",
                        "History",
                        "BA History studies historical events, societies and civilizations.",
                        "Ancient History, Medieval History, Modern History, Research Methods",
                        "Research, Writing, Critical Thinking",
                        "Teacher, Historian, Researcher, Heritage Professional",
                        "Research Assistant, Teacher after required qualification",
                        "MA History, B.Ed, Research Studies",
                        "University/institute-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Arts",
                        "Arts",
                        "BJMC",
                        "3-4 Years",
                        "10+2 with applicable eligibility",
                        "Language and communication skills are useful",
                        "BJMC focuses on journalism, media, communication and content production.",
                        "Journalism, Mass Communication, Media Production, Digital Media",
                        "Communication, Writing, Creativity, Research",
                        "Journalist, Content Professional, Media Professional",
                        "Reporter, Content Writer, Media Executive",
                        "MA Journalism, Mass Communication, Specialized Media Studies",
                        "University/institute-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Arts",
                        "Arts",
                        "BSW",
                        "3-4 Years",
                        "10+2 with applicable eligibility",
                        "Social Science subjects can be helpful",
                        "BSW focuses on social work, community development and social welfare.",
                        "Social Work, Community Development, Social Policy",
                        "Communication, Empathy, Research, Teamwork",
                        "Social Worker, Community Professional, NGO Professional",
                        "Social Worker, Community Coordinator, NGO roles",
                        "MSW, Social Development Studies",
                        "University/institute-specific admission process",
                        "Admission depends on university or college requirements.",
                        "Salary varies according to role, organization and experience."
                ),

                createCourse(
                        "Arts",
                        "Arts",
                        "LLB",
                        "3 Years after graduation / 5 Years integrated route",
                        "Eligibility depends on the selected LLB route and institution",
                        "Varies according to route",
                        "Law studies legal principles, rights, legislation and legal procedures.",
                        "Constitutional Law, Criminal Law, Contract Law, Civil Law",
                        "Communication, Logical Thinking, Research, Reading",
                        "Lawyer after applicable qualification and enrollment, Legal Professional",
                        "Legal Assistant, Legal Executive, Advocate after applicable requirements",
                        "LLM, Specialized Legal Studies",
                        "Applicable law entrance examinations and institution-specific admission",
                        "Admission depends on the route, institution and applicable rules.",
                        "Income varies significantly by role, practice, location and experience."
                ),

                // =====================================================
                // COMPUTER / IT
                // =====================================================

                createCourse(
                        "Computer",
                        "Computer",
                        "BCA",
                        "3-4 Years",
                        "10+2 with applicable eligibility requirements",
                        "Mathematics may be required/preferred by some institutions",
                        "BCA focuses on computer applications, programming and software development.",
                        "Programming, Database, Web Development, Computer Networks",
                        "Programming, Problem Solving, Logical Thinking",
                        "Software Developer, Web Developer, Application Developer",
                        "Software Developer, Web Developer, Technical Support",
                        "MCA, MBA, Specialized Certifications",
                        "University/institute-specific admission process",
                        "Admission depends on institution and applicable rules.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Computer",
                        "Computer",
                        "B.Sc Computer Science",
                        "3-4 Years",
                        "10+2 with applicable eligibility",
                        "Mathematics/Computer Science may be required depending on institution",
                        "B.Sc Computer Science develops knowledge of computing, programming and software.",
                        "Programming, Data Structures, Database, Networks, Operating Systems",
                        "Programming, Problem Solving, Analytical Thinking",
                        "Software Developer, Web Developer, Technical Professional",
                        "Software Developer, Web Developer, Technical Support",
                        "M.Sc Computer Science, MCA, Certifications",
                        "University/institute-specific admission process",
                        "Admission depends on institution and applicable rules.",
                        "Salary varies according to skills, organization and experience."
                ),

                // =====================================================
                // DIPLOMA CSE
                // =====================================================

                createCourse(
                        "Diploma",
                        "Diploma CSE",
                        "B.Tech CSE",
                        "Usually 4 Years; lateral-entry duration may differ",
                        "Diploma qualification and applicable lateral-entry eligibility",
                        "Computer Science and Engineering",
                        "B.Tech CSE provides advanced study of computer science and software engineering.",
                        "Programming, Data Structures, Database, Operating Systems, Networks",
                        "Programming, Problem Solving, Logical Thinking",
                        "Software Engineer, Software Developer, Web Developer",
                        "Software Developer, Web Developer, Backend Developer",
                        "M.Tech, MCA, MBA, Specialized Certifications",
                        "Applicable lateral-entry/entrance process depending on state and institution",
                        "Admission depends on the applicable lateral-entry rules and institution.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Diploma",
                        "Diploma CSE",
                        "B.Tech AI/ML",
                        "Usually 4 Years; lateral-entry duration may differ",
                        "Diploma qualification and applicable eligibility",
                        "Computer/Mathematics-related subjects may be relevant",
                        "B.Tech AI/ML focuses on artificial intelligence, machine learning and data-driven systems.",
                        "Python, Machine Learning, AI, Mathematics, Data Science",
                        "Programming, Mathematics, Analytical Thinking",
                        "AI Engineer, Machine Learning Engineer",
                        "AI Engineer, ML Engineer, Data-related roles",
                        "M.Tech, MS, Specialized AI/ML Certifications",
                        "Applicable lateral-entry/entrance process depending on institution",
                        "Admission depends on applicable rules and institution.",
                        "Salary varies according to skills, company, location and experience."
                ),

                createCourse(
                        "Diploma",
                        "Diploma CSE",
                        "BCA",
                        "3-4 Years",
                        "Diploma qualification and applicable institution eligibility",
                        "Computer-related subjects can be useful",
                        "BCA focuses on computer applications and software development.",
                        "Programming, Database, Web Development, Computer Applications",
                        "Programming, Problem Solving, Communication",
                        "Software Developer, Web Developer, Application Developer",
                        "Software Developer, Web Developer, Technical Support",
                        "MCA, MBA, Specialized Certifications",
                        "University/institute-specific admission process",
                        "Admission depends on institution and applicable rules.",
                        "Salary varies according to skills, organization and experience."
                ),

                createCourse(
                        "Diploma",
                        "Diploma CSE",
                        "Junior Software Developer Job",
                        "Career entry option",
                        "Diploma CSE and job-specific skills",
                        "Programming, Web Development, Database",
                        "Students can enter entry-level IT roles after developing practical skills.",
                        "Programming, HTML, CSS, JavaScript, Database, Git",
                        "Programming, Problem Solving, Communication",
                        "Junior Software Developer, Web Developer, Technical Support",
                        "Junior Software Developer, Web Developer, Technical Support Engineer",
                        "B.Tech, BCA, Certifications, Advanced Skill Development",
                        "Company recruitment, internships and job applications",
                        "Requirements vary by company and job role.",
                        "Salary varies according to company, role, location and skills."
                )
        );

        careerCourseRepository.saveAll(courses);

        System.out.println(
                "Career course data loaded successfully: "
                        + courses.size()
                        + " records"
        );
    }

    private CareerCourse createCourse(
            String stream,
            String subjectCombination,
            String course,
            String duration,
            String eligibility,
            String requiredSubjects,
            String description,
            String mainSubjects,
            String skillsRequired,
            String careerOptions,
            String jobRoles,
            String higherStudies,
            String entranceExams,
            String admissionProcess,
            String salaryInfo) {

        CareerCourse careerCourse = new CareerCourse();

        careerCourse.setStream(stream);
        careerCourse.setSubjectCombination(subjectCombination);
        careerCourse.setCourse(course);
        careerCourse.setDuration(duration);
        careerCourse.setEligibility(eligibility);
        careerCourse.setRequiredSubjects(requiredSubjects);
        careerCourse.setDescription(description);
        careerCourse.setMainSubjects(mainSubjects);
        careerCourse.setSkillsRequired(skillsRequired);
        careerCourse.setCareerOptions(careerOptions);
        careerCourse.setJobRoles(jobRoles);
        careerCourse.setHigherStudies(higherStudies);
        careerCourse.setEntranceExams(entranceExams);
        careerCourse.setAdmissionProcess(admissionProcess);
        careerCourse.setSalaryInfo(salaryInfo);

        return careerCourse;
    }
}