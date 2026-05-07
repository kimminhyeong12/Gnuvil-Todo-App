# Gnuvil Todo App

React와 Spring Boot로 만든 로그인 기반 Todo 애플리케이션입니다.  
사용자는 회원가입/로그인 후 본인의 할 일을 추가, 수정, 완료 처리, 삭제할 수 있습니다.

Render 무료 서버를 사용하고 있어 일정 시간 요청이 없으면 백엔드 서버가 sleep 상태로 전환될 수 있습니다. 이 경우 첫 요청 시 서버가 다시 깨어나는 데 시간이 걸려 로그인이나 Todo 조회가 평소보다 오래 걸릴 수 있습니다

## 배포 주소

- Frontend: https://gnuvil-todo-app.vercel.app
- Backend: https://gnuvil-todo-app.onrender.com

## 기술 스택

### Frontend
- React
- TypeScript
- Vite
- TanStack Query
- Axios
- Tailwind CSS

### Backend
- Java 17
- Spring Boot
- Spring Web
- Spring JPA
- Spring Security
- PostgreSQL

### Deploy
- Vercel
- Render
- Supabase PostgreSQL

## 주요 기능

- 회원가입
- 로그인
- 로그아웃
- 로그인한 사용자별 Todo 조회
- Todo 추가
- Todo 수정
- Todo 완료 상태 토글
- Todo 삭제
