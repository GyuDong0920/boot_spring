
 Filter
 
 학습 목표
 
 Filter에 대한 개념을 이해하자
 
 GlobalFilter Class를 생성
 
 ContentCachingRequestWrapper, ContentChahingResponseWrapper
 
 클래스의 활용 방법
 
 Filter 란 Web Application 에서 관리되는 영역으로 Spring boot Framework 에서
 오는 요청/응답에 대해서 최초/최종 위치에 존재하며, 이를 통해서
 요청/응답의 정보를 변경하거나, Spring에 의해서 데이터가 변환되기 전에 
 순수한 Client 의 요청/응답 값을 확인할 수 있다.
 
 Spring 중 가장 핵심 개념 3가지 중 하나인 (IoC)

 inversion of controller 제어의 역전
 
spring 실행시 컴포넌트스캔을 함
메모리에 올려야할 객체들을 스캔하고 올림

-- 싱글톤 패턴으로 관리됌

DI 로 가져와서 사용할 수 있음 - 의존 주입

