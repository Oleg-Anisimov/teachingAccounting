import { createI18n } from 'vue-i18n'

const i18n = createI18n({
    locale: 'ru',
    messages:{
        ru: {
            enum: {
                categories: {
                    WITHOUT_CATEGORY:"Без категории",
                    FIRST_CATEGORY:"Первая категория",
                    HIGHEST_CATEGORY:"Высшая категория"
                },
                employmentType: {
                    REGULAR: "Штатный",
                    INNER_REGULAR_PART_TIME_WORKER: "Внутренний штатный совместитель",
                    EXTERNAL_PART_TIME_WORKER: "Внешний совместитель"
                },
                position: {
                    TEACHER: "Преподаватель",
                    DIRECTOR: "Директор",
                },
                eventLevel: {
                    INTERNATIONAL: "Международный",
                    ALL_RUSSIAN: "Всероссийский",
                    REGIONAL: "Региональный",
                    URBAN: "Городской",
                    UNIVERSITY: "Университетский",
                    COLLEGE: "Колледжный"
                },
                eventType: {
                    INTERNET_TESTING_FEPO: "Интернет-тестирование: ФЭПО",
                    INTERNET_TESTING_TRAINERS: "Интернет-тестирование: тренажеры",
                    OPEN_DAY: "День открытых дверей",
                    QUEST_GAME: "Квест-игра",
                    SUBJECT_GROUP_WORK : "Работа предметного кружка",
                    INTERNET_TESTING_INTERNET_OLIMPIADA: "Интернет-тестирование: интернет-олимпиада",
                    LAB_LESSONS_BASED_ON_MGTU: "Лабораторные (практические) занятия на базе МГТУ",
                    OPEN_EDUCATION_LESSON: "Открытое учебное занятие",
                    OPEN_EVENT: "Открытое мероприятие",
                    PRACTICE_RESULT_EVENT: "Мероприятие по итогам практики",
                    EMPLOYMENT_ASSISTANCE_EVENT_FOR_ALUMNI: "Мероприятие для выпускников по содействию в трудоустройстве",
                    PROFESSIONAL_SKILLS_COMPETITION_IN_THE_PROFESSION_OF_A_WORKER_OR_EMPLOYEE: "Конкурс профессионального мастерства по профессии рабочего/должности служащего",
                    PROFESSIONAL_SKILLS_OLYMPIAD_IN_SPECIALITY: "Олимпиада профессионального мастерства по специальности",
                    PROFESSIONAL_SKILLS_COMPETITION_IN_THE_COMPETENCE: "Конкурс профессионального мастерства по компетенции",
                    PROFESSIONAL_AUDITIONS: "Профессиональные пробы",
                    OLIMPIADA: "Олимпиада",
                    COMPETITION: "Конкурс",
                    STUDENT_CONFERENCE: "Студенческая конференция",
                    OPEN_DEFENCE_OF_COURSE_PROJECTS_OR_WORKS: "Открытая защита курсовых проектов/работ",
                    EMPLOYER_MEETING: "Встреча с работодателем",
                    EXCURSION_TO_THE_ENTERPRISE_BY_SPECIALITY: "Экскурсия на предприятие (по специальности)",
                    CAMPAIGNING_AND_CAREER_GUIDANCE_AT_PARENT_MEETING_AT_SCHOOL: "Агитационно-профориентационная работа на родительских собраниях в школе",
                    ADDITIONAL_PROFESSIONAL_PROGRAM_TRAINING: "Дополнительная программа профессиональной подготовки",
                    ADDITIONAL_EDUCATION_PROGRAM: "Дополнительная общеразвивающая программа",
                    DEMONSTRATION_EXAM_OF_COMPETENCE: "Демонстрационный экзамен по компетенции",
                    INDIVIDUAL_SUPPORT_PROGRAM_FOR_DISABLED_STUDENT: "Индивидуальная программа сопровождения обучающегося инвалида / обучающегося с ОВЗ",
                    MASTERCLASS: "Мастер-класс",
                    DIAGNOSTIC_TESTING: "Диагностическое тестирование",
                    ROUND_TABLE: "Круглый стол",
                    MARATHON: "Марафон",
                    ACTION: "Акция",
                    VICTORINE: "Викторина",
                    MEETING: "Встреча",
                    EXHIBIT: "Выставка",
                    VISITING: "Посещение",
                    STUDENT_ACTIVE: "Студенческий актив",
                    CLASS_HOUR: "Классный час",
                    CONFERENCE: "Конференция",
                    CONCERT: "Концерт",
                    LECTORY: "Лекторий",
                    FORUM: "Форум (фестиваль, слет, сбор)",
                    SOCIAL_HELPFUL_WORK: "Общественно-полезный труд",
                    LESSON: "Урок",
                    HISTORICAL_PARADE_MARCH: "Парад, шествие, марш, посвященные памятному событию, дате",
                    GTO_STANDARTS_CHECK: "Сдача норм ГТО",
                    TOURNAMENT: "Соревнование",
                    SPARTAKIAD: "Спартакиада",
                    FEAST: "Праздник",
                    TRAINING: "Тренинг",
                    STUDENT_ASSOCIATION: "Студенческое объединение",
                    CHATTING_HOURS: "Часы общения",
                    PROJECT: "Проект",
                    EXCURSION: "Экскурсия",
                    GAME: "Игра",
                    CONSUMER: "Собрание",
                    SPORT_SECTION: "Спортивная секция",
                    SATURDAY_WORK: "Субботник",
                    SCHOOL_OF_SOCIAL_DESIGN: "Школа социального проектирования",
                    DICTANT: "Диктант"
                },
                WorkVector: {
                    PROFESSIONAL_ORIENTATED: "Профессионально-ориентирующее",
                    CIVIL_PATRIOTIC: "Гражданско-патриотическое",
                    CULTURE_CREATIVE: "Культурно-творческое",
                    SPORTS_AND_HEALTHCARE: "Спортивное и здоровьесберегающее",
                    ECOLOGIC: "Экологическое",
                    STUDENT_SELF_ADMINISTRATION_DEVELOPMENT: "Развитие студенческого самоуправления",
                    PREVENTION_OF_UNLAWFUL_BEHAVIOR: "Профилактика противоправного поведения",
                    LABOR: "Трудовое",
                    CONTINGENT_SAFETY: "Сохранность контингента"
                },
                ActivityType: {
                    ACTUALIZATION: "Актуализация",
                    DOCUMENTATION_MANAGEMENT: "Ведение документов",
                    CRAFTING_OR_FIXING: "Изготовление и / или ремонт",
                    DEVELOPMENT: "Разработка",
                    DEVELOPMENT_WORK_GROUP: "Разработка (рабочая группа)",
                    ORGANIZATION_FOR_PC_PCK: "Организация (для председателей ПК/ПЦК)",
                    PROVIDENCE: "Проведение",
                    PARTICIPATION: "Участие",
                    PARTICIPATION_PREPARE: "Подготовка к участию",
                    MANAGEMENT_OF_INTERNSHIPS_FOR_STUDENTS_IN_HIGHER_EDUCATION_PROGRAMS: "Руководство практикой обучающихся по программам высшего образования",
                    REALIZATION: "Реализация",
                    ORGANIZATION: "Организация",
                    JOINT_ORGANIZATION: "Совместная организация"
                },
                ParticipationType: {
                    PARTICIPATION: "Участие",
                    PUBLICATION: "Публикация",
                    REPORT: "Доклад",
                    REGISTRATION: "Регистрация",
                    PERSONAL: "Очное",
                    NON_PERSONAL: "Заочное",
                    DISTANCE: "Дистанционное"
                },
                CabinetType: {
                    CABINET: "Кабинет",
                    LABORATORY: "Лаборатория",
                    WORKSHOP: "Мастерская",
                    SPORT_COMPLEX: "Спортивный комплекс",
                    HALL: "Зал",
                    POLYGON: "Полигон",
                    TRAINING_COMPLEX: "Тренажер, тренажерный зал",
                    STUDIO: "Студия"
                },
                PromotionForm: {
                    PARTICIPATION_IN_THE_INTRA_COLLEGE_EDUCATION_SYSTEM_ACTIVITIES: "Участие в мероприятиях системы внутриколледжного обучения",
                    QUALIFICATION_PROMOTION_COURSES_STUDYING: "Обучение на курсах повышения квалификации",
                    ATTESTATION: "Аттестация",
                    ONLINE_COURSES: "Онлайн курсы",
                    STAGING: "Стажировка",
                    ASPIRANTHUR: "Аспирантура",
                    MAGISTRATURE: "Магистратура",
                    PROFESSIONAL_RETRAINING: "Профессиональная переподготовка"
                }
            }
        }
    }
});

export default i18n;