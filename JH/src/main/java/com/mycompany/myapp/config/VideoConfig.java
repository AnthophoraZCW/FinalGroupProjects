package com.mycompany.myapp.config;

import com.mycompany.myapp.domain.Video;
import com.mycompany.myapp.domain.enumeration.Rating;
import com.mycompany.myapp.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoConfig {
    @Bean
    public CommandLineRunner initData(VideoRepository videoRepository) {
        return args -> {
            // Video Data initialization
            Video video1 = new Video();
            video1.setTitle("Power");
            video1.setDescription("James \"Ghost\" St. Patrick, a wealthy New York nightclub owner who has it all; dreaming big, catering to the city's elite, and living a double life as a drug kingpin.");
            video1.setReleaseYear(2014);
            video1.setClassification("TV Series");
            video1.setDuration(58);
            video1.setEpisode(63);
            video1.setSeason(6);
            video1.setRating(Rating.TV_MA);
            video1.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Power.mp4");

            Video video2 = new Video();
            video2.setTitle("Run The World");
            video2.setDescription("The story of a group of Black women – vibrant, fiercely loyal best friends – who work, live and play in Harlem as they strive for world domination.");
            video2.setReleaseYear(2021);
            video2.setClassification("TV Series");
            video2.setDuration(26);
            video2.setEpisode(16);
            video2.setSeason(2);
            video2.setRating(Rating.TV_MA);
            video2.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Run+the+World+.mp4");

            Video video3 = new Video();
            video3.setTitle("Courage The Cowardly Dog");
            video3.setDescription("A cowardly dog who must overcome his own fears to heroically defend his unknowing farmer owners from all kinds of dangers, paranormal events and menaces that appear around their land.");
            video3.setReleaseYear(1999);
            video3.setClassification("TV Series");
            video3.setDuration(22);
            video3.setEpisode(52);
            video3.setSeason(4);
            video3.setRating(Rating.TV_Y7);
            video3.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Courage+The+Cowardly+Dog.mp4");

            Video video4 = new Video();
            video4.setTitle("Kenan & Kel");
            video4.setDescription("Kenan and Kel: two best friends who live in Chicago are always dragged down by Kenan's get rich quick schemes while orange soda-loving buddy Kel is dragged along but tends to mess things up.\t");
            video4.setReleaseYear(1996);
            video4.setClassification("TV Series");
            video4.setDuration(24);
            video4.setEpisode(65);
            video4.setSeason(4);
            video4.setRating(Rating.G);
            video4.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Kenan+and+Kel+.mp4");

            Video video5 = new Video();
            video5.setTitle("Baki");
            video5.setDescription("The protagonist, Baki Hanma, trains with an intense focus to become strong enough to surpass his father, Yujiro Hanma, the strongest fighter in the world.");
            video5.setReleaseYear(2018);
            video5.setClassification("TV Series");
            video5.setDuration(43);
            video5.setEpisode(39);
            video5.setSeason(2);
            video5.setRating(Rating.TV_MA);
            video5.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Baki+Hanma+.mp4");

            Video video6 = new Video();
            video6.setTitle("The Walking Dead");
            video6.setDescription("Sheriff Deputy Rick Grimes wakes up from a coma to learn the world is in ruins and must lead a group of survivors to stay alive.");
            video6.setReleaseYear(2010);
            video6.setClassification("TV Series");
            video6.setDuration(44);
            video6.setEpisode(177);
            video6.setSeason(11);
            video6.setRating(Rating.TV_MA);
            video6.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Walking+Dead+Trailer+(First+Season).mp4");

            Video video7 = new Video();
            video7.setTitle("Titanic");
            video7.setDescription("A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.");
            video7.setReleaseYear(1996);
            video7.setClassification("Movie");
            video7.setDuration(195);
            video7.setEpisode(0);
            video7.setSeason(0);
            video7.setRating(Rating.PG13);
            video7.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Titanic+(1997)+Trailer+%231+%7C+Movieclips+Classic+Trailers.mp4");

            Video video8 = new Video();
            video8.setTitle("Drumline");
            video8.setDescription("A band director recruits an ego driven Harlem drummer to play at a Southern university.");
            video8.setReleaseYear(2002);
            video8.setClassification("TV Series");
            video8.setDuration(120);
            video8.setEpisode(0);
            video8.setSeason(0);
            video8.setRating(Rating.PG13);
            video8.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Drumline+Trailer.mp4");

            Video video9 = new Video();
            video9.setTitle("Law Abiding Citizen");
            video9.setDescription("A frustrated man decides to take justice into his own hands after a plea bargain sets one of his family's killers free.");
            video9.setReleaseYear(2009);
            video9.setClassification("Movie");
            video9.setDuration(118);
            video9.setEpisode(0);
            video9.setSeason(0);
            video9.setRating(Rating.R);
            video9.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/LAW+ABIDING+CITIZEN+.mp4");

            Video video10 = new Video();
            video10.setTitle("Toy Story");
            video10.setDescription("A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.");
            video10.setReleaseYear(1995);
            video10.setClassification("Movie");
            video10.setDuration(81);
            video10.setEpisode(0);
            video10.setSeason(0);
            video10.setRating(Rating.G);
            video10.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Toy+Story+(1995)+Trailer+%231+%7C+Movieclips+Classic+Trailers.mp4");

            Video video1500 = new Video();
            video1500.setTitle("The Santa Claus 3: The Escape Clause");
            video1500.setDescription("Santa, a.k.a. Scott Calvin, is faced with double-duty: how to keep his new family happy and how to stop Jack Frost from taking over Christmas.");
            video1500.setReleaseYear(2006);
            video1500.setClassification("Movie");
            video1500.setDuration(92);
            video1500.setEpisode(0);
            video1500.setSeason(0);
            video1500.setRating(Rating.G);
            video1500.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Santa+Clause+3_+The+Escape+Clause+(2006)+Official+Trailer.mp4");

            Video video1501 = new Video();
            video1501.setTitle("The Wolf of Wall Street");
            video1501.setDescription("Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.");
            video1501.setReleaseYear(2013);
            video1501.setClassification("Movie");
            video1501.setDuration(180);
            video1501.setEpisode(0);
            video1501.setSeason(0);
            video1501.setRating(Rating.R);
            video1501.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Wolf+of+Wall+Street+-+Official+Trailer+(HD).mp4");

            Video video1502 = new Video();
            video1502.setTitle("IT");
            video1502.setDescription("Set in Derry, Maine. The film tells the story of The Losers' Club , a group of seven outcast children who are terrorized by the eponymous being which emerges from the sewer , only to face their own personal demons in the process.");
            video1502.setReleaseYear(2017);
            video1502.setClassification("Movie");
            video1502.setDuration(135);
            video1502.setEpisode(0);
            video1502.setSeason(0);
            video1502.setRating(Rating.R);
            video1502.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/IT+-+Official+Teaser+Trailer.mp4");

            Video video1503 = new Video();
            video1503.setTitle("The Boondock Saints");
            video1503.setDescription("Two Irish Catholic brothers become vigilantes and wipe out Boston's criminal underworld in the name of God.");
            video1503.setReleaseYear(1999);
            video1503.setClassification("Movie");
            video1503.setDuration(108);
            video1503.setEpisode(0);
            video1503.setSeason(0);
            video1503.setRating(Rating.R);
            video1503.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/BOONDOCK+SAINTS.mp4");

            Video video1504 = new Video();
            video1504.setTitle("Baby Boy");
            video1504.setDescription("The story of Jody, a misguided, 20-year-old African-American who is really just a baby boy finally forced-kicking and screaming to face the commitments of real life.\t");
            video1504.setReleaseYear(2001);
            video1504.setClassification("Movie");
            video1504.setDuration(130);
            video1504.setEpisode(0);
            video1504.setSeason(0);
            video1504.setRating(Rating.R);
            video1504.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/BABY+BOY+.mp4");

            Video video1505 = new Video();
            video1505.setTitle("The Boondocks");
            video1505.setDescription("Brothers Huey and Riley Freeman experience a culture clash when they leave Chicago to move in with their grandfather in the suburbs.");
            video1505.setReleaseYear(2005);
            video1505.setClassification("TV Series");
            video1505.setDuration(22);
            video1505.setEpisode(55);
            video1505.setSeason(4);
            video1505.setRating(Rating.TV_MA);
            video1505.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Boondocks+.mp4");

            Video video1506 = new Video();
            video1506.setTitle("Bluey");
            video1506.setDescription("The slice-of-life adventures of an Australian Blue Heeler Cattle Dog puppy as she has fun with her family and friends in everyday situations.");
            video1506.setReleaseYear(2018);
            video1506.setClassification("TV Series");
            video1506.setDuration(7);
            video1506.setEpisode(151);
            video1506.setSeason(3);
            video1506.setRating(Rating.TV_Y);
            video1506.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/+Bluey+.mp4");

            Video video1507 = new Video();
            video1507.setTitle("The Grim Adventures of Billy & Mandy");
            video1507.setDescription("Billy's hamster turned 10 in human years, but was awaiting to see the Grim Reaper. Billy and his friend, Mandy challenge the Reaper to a game of limbo to become best friends.");
            video1507.setReleaseYear(2001);
            video1507.setClassification("TV Series");
            video1507.setDuration(30);
            video1507.setEpisode(84);
            video1507.setSeason(6);
            video1507.setRating(Rating.TV_Y7);
            video1507.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/+The+Grim+Adventures+of+Billy+and+Mandy.mp4");

            Video video1508 = new Video();
            video1508.setTitle("The Office");
            video1508.setDescription("A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.");
            video1508.setReleaseYear(2005);
            video1508.setClassification("TV Series");
            video1508.setDuration(22);
            video1508.setEpisode(201);
            video1508.setSeason(9);
            video1508.setRating(Rating.TV_14);
            video1508.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Office+.mp4");

            Video video1509 = new Video();
            video1509.setTitle("All That");
            video1509.setDescription("\"Saturday Night Live\" for a Nickelodeon audience. A zany sketch comedy featuring many wacky characters hosted for kids and by kids.");
            video1509.setReleaseYear(1994);
            video1509.setClassification("TV Series");
            video1509.setDuration(30);
            video1509.setEpisode(211);
            video1509.setSeason(11);
            video1509.setRating(Rating.G);
            video1509.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/All+That.mp4");

            Video video1510 = new Video();
            video1510.setTitle("The Lion King");
            video1510.setDescription("Set in a kingdom of lions in Africa, The Lion King tells the story of Simba (Swahili for lion), a lion cub who is to succeed his father, Mufasa, as King of the Pride Lands.\t");
            video1510.setReleaseYear(1994);
            video1510.setClassification("Movie");
            video1510.setDuration(88);
            video1510.setEpisode(0);
            video1510.setSeason(0);
            video1510.setRating(Rating.G);
            video1510.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Lion+King+(1994)+Trailer+%231+%7C+Movieclips+Classic+Trailers.mp4");

            Video video1511 = new Video();
            video1511.setTitle("The Land Before Time");
            video1511.setDescription("An orphaned brontosaurus teams up with other young dinosaurs in order to reunite with their families in a valley.");
            video1511.setReleaseYear(1988);
            video1511.setClassification("Movie");
            video1511.setDuration(69);
            video1511.setEpisode(0);
            video1511.setSeason(0);
            video1511.setRating(Rating.G);
            video1511.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Land+Before+Time+(1988)+Theatrical+Trailer.mp4");

            Video video1512 = new Video();
            video1512.setTitle("SpongeBob SquarePants");
            video1512.setDescription("The misadventures of a talking sea sponge who works at a fast food restaurant, attends a boating school, and lives in an underwater pineapple.");
            video1512.setReleaseYear(1999);
            video1512.setClassification("TV Series");
            video1512.setDuration(23);
            video1512.setEpisode(296);
            video1512.setSeason(14);
            video1512.setRating(Rating.TV_Y7);
            video1512.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/SpongeBob.mp4");

            Video video1513 = new Video();
            video1513.setTitle("Breaking Bad");
            video1513.setDescription("A chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine with a former student in order to secure his family's future.");
            video1513.setReleaseYear(2008);
            video1513.setClassification("TV Series");
            video1513.setDuration(58);
            video1513.setEpisode(62);
            video1513.setSeason(5);
            video1513.setRating(Rating.TV_MA);
            video1513.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Breaking+Bad.mp4");

            Video video1514 = new Video();
            video1514.setTitle("Silicon Valley");
            video1514.setDescription("Follows the struggle of Richard Hendricks, a Silicon Valley engineer trying to build his own company called Pied Piper.");
            video1514.setReleaseYear(2014);
            video1514.setClassification("TV Series");
            video1514.setDuration(28);
            video1514.setEpisode(53);
            video1514.setSeason(6);
            video1514.setRating(Rating.TV_MA);
            video1514.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Silicon+Valley.mp4");

            Video video1515 = new Video();
            video1515.setTitle("My Hero Academia");
            video1515.setDescription("A superhero-admiring boy enrolls in a prestigious hero academy and learns what it really means to be a hero, after the strongest superhero grants him his own powers.");
            video1515.setReleaseYear(2016);
            video1515.setClassification("TV Series");
            video1515.setDuration(24);
            video1515.setEpisode(113);
            video1515.setSeason(6);
            video1515.setRating(Rating.TV_14);
            video1515.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/My+Hero+Academia+-+Broadcast+Dub+Trailer.mp4");

            Video video1517 = new Video();
            video1517.setTitle("Key and Peele");
            video1517.setDescription("Project sees Keegan-Michael Key and Jordan Peele in front of a live studio audience bantering about a topic weaved between filmed shorts and sketches.");
            video1517.setReleaseYear(2012);
            video1517.setClassification("TV Series");
            video1517.setDuration(30);
            video1517.setEpisode(53);
            video1517.setSeason(5);
            video1517.setRating(Rating.TV_14);
            video1517.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/+Key+%26+Peele.mp4");

            Video video1518 = new Video();
            video1518.setTitle("Shrek");
            video1518.setDescription("A mean lord exiles fairytale creatures to the swamp of a grumpy ogre, who must go on a quest and rescue a princess for the lord in order to get his land back.");
            video1518.setReleaseYear(2001);
            video3.setClassification("Movie");
            video3.setDuration(90);
            video3.setEpisode(0);
            video3.setSeason(0);
            video3.setRating(Rating.PG);
            video3.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/Shrek.mp4");

            Video video1519 = new Video();
            video1519.setTitle("Thor: Ragnarok");
            video1519.setDescription("Imprisoned on the planet Sakaar, Thor must race against time to return to Asgard and stop Ragnarök, the destruction of his world, at the hands of the powerful and ruthless villain Hela.");
            video1519.setReleaseYear(2017);
            video1519.setClassification("Movie");
            video1519.setDuration(130);
            video1519.setEpisode(0);
            video1519.setSeason(0);
            video1519.setRating(Rating.PG13);
            video1519.setVideoURL("\thttps://nexflixclonefinal.s3.amazonaws.com/Thor+Ragnarok.mp4");

            Video video1520 = new Video();
            video1520.setTitle("The Fast and the Furious: Tokyo Drift");
            video1520.setDescription("A teenager becomes a major competitor in the world of drift racing after moving in with his father in Tokyo to avoid a jail sentence in America.");
            video1520.setReleaseYear(2006);
            video1520.setClassification("Movie");
            video1520.setDuration(104);
            video1520.setEpisode(0);
            video1520.setSeason(0);
            video1520.setRating(Rating.PG13);
            video1520.setVideoURL("https://nexflixclonefinal.s3.amazonaws.com/The+Fast+and+The+Furious+Tokyo+Drift+.mp4");

            Video video1521 = new Video();
            video1521.setTitle("Joker");
            video1521.setDescription("During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.");
            video1521.setReleaseYear(2019);
            video1521.setClassification("Movie");
            video1521.setDuration(122);
            video1521.setEpisode(0);
            video1521.setSeason(0);
            video1521.setRating(Rating.R);
            video1521.setVideoURL("\thttps://nexflixclonefinal.s3.amazonaws.com/JOKER+.mp4");

            // Save the videos to the database
            videoRepository.save(video1);
            videoRepository.save(video2);
            videoRepository.save(video3);
            videoRepository.save(video4);
            videoRepository.save(video5);
            videoRepository.save(video6);
            videoRepository.save(video7);
            videoRepository.save(video8);
            videoRepository.save(video9);
            videoRepository.save(video10);
            videoRepository.save(video1500);
            videoRepository.save(video1501);
            videoRepository.save(video1502);
            videoRepository.save(video1503);
            videoRepository.save(video1504);
            videoRepository.save(video1505);
            videoRepository.save(video1506);
            videoRepository.save(video1507);
            videoRepository.save(video1508);
            videoRepository.save(video1509);
            videoRepository.save(video1510);
            videoRepository.save(video1511);
            videoRepository.save(video1512);
            videoRepository.save(video1513);
            videoRepository.save(video1514);
            videoRepository.save(video1515);
            videoRepository.save(video1517);
            videoRepository.save(video1518);
            videoRepository.save(video1519);
            videoRepository.save(video1520);
            videoRepository.save(video1521);

        };
    }
}
