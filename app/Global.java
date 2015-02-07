import static play.mvc.Results.notFound;
import static play.mvc.Results.badRequest;
import models.SurferDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.libs.F.Promise;
import play.mvc.SimpleResult;
import play.mvc.Http.RequestHeader;
import views.formdata.SurferFormData;

/**
 * Initializes surfers on start up.
 * 
 * @author Alvin Wang
 * 
 */
public class Global extends GlobalSettings {
  
  
  /**
   * Initializes surfers.
   * 
   * @param app The application.
   */
  public void onStart(Application app) {
    //String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
    //String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");

    UserInfoDB.defineAdmin("Administrator", "admin@admin.com", "adminpass");

    if (SurferDB.getSurfers().isEmpty()) {

      /** MALES **/
      SurferDB.addSurfer(new SurferFormData("CJ Hobgood", "Melbourne, Florida", "United States",
          "2007 US Open of Surfing",
          "http://www.lat34.org/quick_hits/wp-content/uploads/2008/10/hobgood_cj8331mundaka08cestari_l.jpg",
          "http://image.surfingmagazine.com/f/news/surfing-profiles/31364595+w545+st0/2006-cj-hobgood-lrg.jpg", "C.J. "
              + "entered his first surfing contest in 1989 and made the Open Boys final. He placed second in a national"
              + " competition the following year. He won several other championships and in 1998 he was selected as the"
              + " model for the new National Scholastic Surfing Association logo. In 1999, CJ was the Association "
              + "Surfer Professionals Rookie of the Year. In 2001 he won the ASP World Championship. He currently "
              + "resides in Satellite Beach, Florida with his wife and daughter, near his younger brother Travis, his "
              + "younger sister Marissa, and his parents.", "cjhobgood", "Male", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Adriano De Souza", "Sau Paulo, Brazil", "Brazil", "Rip Curl Pro Bells "
          + "Beach (2013), Rip Curl Pro Portugal (2011), Billabong Pro Rio (2011)", 
          "http://tribalpoint.com.br/facecms/uploads/galeria/pj_1304093313.jpg", 
          "http://dawf3zk2mt55y.cloudfront.net/wp-content/uploads/2011/01/Profile-Adriano-Desouza.jpg", "Adriano De"
              + " Souza rode his first wave at eight years old and eight years later the surf world would take notice "
              + "of this young, talented surfer at the Billabong ASP World Junior Championships. At the 2004 event, he"
              + " defeated opponents four years his senior and was named the youngest ASP World Junior Champion ever at"
              + " 16. Spectators observed his fast, energetic surfing and he quickly became known as one of the most "
              + "exciting surfers to watch. In 2005, he won the ASP WQS by the widest margin in history. That win took "
              + "him into his first year on the ASP World Tour where he finished an impressive 18th in the world. "
              + "Although his style is more conducive to smaller beachbreaks, he is showing his competitors that he "
              + "can also handle big wave surf, giving his country hope that he has what it takes to transition from a "
              + "junior champion to something much more. To date, he's one of the most ferocious competitors the sport"
              + " has ever seen and it shows in the ratings, with consistent top 10 overall finishes since 2008, "
              + "positioning himself as a serious contender for a world title.", "adrianodesouza", "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Ezekiel Lau", "Honolulu, Hawaii", "United States",
          "ASP 4-Star HIC Pro Champion",
          "http://cdn.alohaupdate.com/wp-content/uploads/2011/11/Ezekiel-Lau-Wins-HIC-Pro-2011.jpg", 
          "http://solspot.com/content/wp-content/uploads/2012/07/NSSA-Natls-Open-Mens_Ezekiel_Lau_6943.jpg", 
          "Ezekiel Lau (better known as Zeke) is coming of age as a surfer and competitor right in front of our eyes "
              + "with some impressive and creative surfing. Zeke is known for having a unique blend of style, speed,"
              + " and power. Ezekiel sets himself apart as a private school student at Kamehameha Schools "
              + "(an Institution for students of Hawaiian Ancestry) while pursuing a competitive surfing career in"
              + " which he claimed 4 National Titles. Surfing is his passion and he hopes you will developa passion"
              + " for watching him as he comes up in rank as the next generation of surfing’s’ finest.", "ezekiellau",
              "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Kelly Slater", "Cocoa Beach, Florida", "United States",
          "ASP World Tour Champion (11 times), Boost Mobile Pro (1st Place, 2007)",
          "http://img.bnqt.com/CMS/bnqt/network/shredstix.com/media/jimbo/0018-4ca7ff48-4b7459f0-8a06-5d1b5626.jpg",
          "http://i2.listal.com/image/4332731/600full-kelly-slater.jpg", "In addition to the ASP tour, Slater has also"
              + " competed in the X-Games (in 2003 and 2004). After earlier being awarded the title prematurely as a"
              + " result of a miscalculation by the ASP, on November 6, 2011 Slater officially won his eleventh ASP"
              + " world title at the Rip Curl Pro Search San Francisco, by winning his 4th round heat. In May 2005, "
              + "in the final heat of the Billabong Tahiti Pro contest at Teahupo'o, Slater became the first surfer "
              + "ever to be awarded two perfect scores for a total 20 out of 20 points under the ASP two-wave "
              + "scoring system. (The corresponding honor under the previous three-wave system belongs to fellow "
              + "American Shane Beschen who achieved the feat in 1996.) He did it again on June 2013 at the quarter "
              + "finals at the Volcom Fiji Pro with two perfect ten waves, only the fourth person in history to do so."
              + " Since 1990, Slater has been sponsored primarily by surfwear industry giant Quiksilver. He "
              + "exclusively rides Channel Islands surfboards equipped with his own signature series of FCS fins.", 
          "kellyslater", "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("John Florence", "Honoulu, Hawaii", "United States",
          "2013 Volcom Pipe Pro", "http://cdn.surf.transworld.net/files/2010/02/brian_bielmann__38q4371.jpg", 
          "http://www.surfertoday.com/images/stories/johnjohnflorence4.jpg", "Florence became well known in the winter"
              + " of late 2005 and early 2006 when he became the youngest surfer ever to compete in the Vans Triple "
              + "Crown of Surfing. He had previously won five amateur awards, the 2003 1st NSSA Nationals Open Mini"
              + " Grom, the 2005 1st NSSA Nationals Open Boy's, the 2005 NSSA Open Boys and the Explorer Menehune "
              + "Champion. He did not pass the first round, but he did score higher than Shane Dorian, a professional"
              + " surfer twenty years Florence's senior. Afterwards, Florence said he was 'pretty scared' but that he"
              + " was 'happy with how [he] did'.", "johnflorence", "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Joel Parkinson", "Nambour, Queensland", "Australia",
          "2012 Billabong Pipeline Masters Winner",
          "http://www.surf-shop.org/wp-content/uploads/2013/02/joel-parkinson.jpg",
          "http://upload.wikimedia.org/wikipedia/commons/f/ff/Joelparkinson.jpg", 
          "Joel Parkinson is an Australian surfer who competes on the ASP (Association Of Surfing Professionals) "
             + "World Tour. After twelve years competing at the elite level on the ASP World Championship Tour, a "
             + "stretch that saw him win eleven elite ASP World Title Events, plus nine additional ASP tour events, " 
             + "and achieve runner-up second place to the ASP World Title four times, Parkinson won his only ASP World" 
             + " Championship Tour Surfing Title on 14 December 2012 in Hawaii at the Banzai Pipeline during the ASP "
             + "World Tours' final event for 2012–the Billabong Pipeline Masters. Parkinson hung on in a grueling " 
             + "back and forth battle with eleven-time ASP World Title holder, Kelly Slater, to get his first World " 
             + "Title, as well as go on to win the highly-coveted Pipeline Masters, only after Slater lost his " 
             + "semi-final heat toJosh Kerr, of Queensland, Australia. Parkinson beat Kerr in the finals of the " 
             + "event, which was his seventh top-five placing for the year, and his first event title win for 2012.", 
          "joelparkinson", "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Jeremy Flores", "Reunion Island", "France",
          "2009 ISA World Champion", 
          "http://cdn2.coresites.mpora.com/surfeurope_new/wp-content/uploads/2013/09/Jeremy-Flores1.jpg",
          "http://1.bp.blogspot.com/-15lZmzc6nD4/Tl06QEFQChI/AAAAAAAAAqs/gCMC1_7kh0s/s1600/22.jpg",  
          "Jérémy Florès (born Reunion Island, April 27, 1988) is a French surfer who grew up on Reunion Island, " 
              + "France, where he began surfing at the age of 3. He continued his surfing development on family trips" 
              + " to Australia, Europe and Hawaii, all the while maintaining his education through correspondence "
              + "courses. He turned professional in 2007, the same year in which he was awarded 'Rookie of the Year' "
              + "by the ASP, and in 2010 he won the prestigious Billabong Pipeline Masters in Hawaii.", "jeremyflores", 
          "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Rabbit Kekai", "Honolulu, Hawaii", "United States",
          "1973, 1980, 1984, 1988 United States Surfing Champion", 
          "http://encyclopediaofsurfing.com/wp-content/uploads/2012/08/Rabbit_Kekai_Queens.jpg", 
          "http://cdn.business.transworld.net/wp-content/blogs.dir/1/files/2012/07/Rabbit_press-release-copy2.jpg", 
          "Born November 11th, 1920, Rabbit Kekai rode his first wave in 1925. For more than eighty years the "
              + "ocean has been his playground, his home and his own personal arena of excellence. He is an icon and "
              + "mainstay in surfing's elite history. Rabbit obtained international notoriety in the newsreels of the "
              + "40's and 50's when the rest of the world was first introduced to men riding wooden planks in the "
              + "pristine waters and surf of the Hawaiian Islands. His contest record is unparalleled and he is still "
              + "winning contests around the globe. His knowledge of the sea has made him a Master Waterman and he has "
              + "successfully competed in paddleboard racing, tandem surfing, canoeing, outriggers and surfing contests"
              + ". At 80, Rabbit is still one of the toughest competitors you'll ever face in a heat. His life and "
              + "exploits have made him an icon in the sport, but anyone who has ever met this man has found a truly "
              + "humble and most generous person. Having long been considered the King of Hawaiian Surf Lore, Rabbit "
              + "is the ultimate storyteller. He weaves stories of legendary surf and the people who mastered the"
              + "sport.", "rabbitkekai", "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Sunny Garcia", "Maili, Hawaii", "United States",
          "2000 ASP WCT World Champion, 6-time Triple Crown of Surfing Title", 
          "http://images.fineartamerica.com/images-medium-large/sunny-garcia-surfing-at-bowls-paul-topp.jpg", 
          "http://uemurasurfboards.com/wp-content/uploads/2012/09/Screen-shot-2012-09-04-at-12.10.19-PM.png", 
          "Sunny Garcia was born Vincent Sennen Garcia on January 14, 1970 in Ma'ili, on the Westside of Oahu, "
              + "Hawaii. He grew up in Wai'anae and after leaving school, debuted on the 1986 Gotcha Pro at Sandy "
              + "Beach, Oahu, beating the 1984 champ Tom Carroll. His top surfing achievement was becoming the ASP "
              + "WCT World Champion in 2000 but Garcia also holds the record for most WQS event wins, 22, and holds "
              + "six Triple Crown of Surfing titles. In addition, he was the second professional surfer to win over "
              + "$1 million in prize money. He initially retired in 2005 but is now competing again, although in 2008, "
              + "his hopes for ASP World Tour qualification were dashed with early elimination in the O'Neill World "
              + "Cup of Surfing.", "sunnygarcia", "Male", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Eddie Aikau", "Kahului, Maui, Hawaii", "United States",
          "1971 Lifeguard of the Year", 
          "http://www.eddieaikaufoundation.org/photos/p02.jpg", 
          "http://upload.wikimedia.org/wikipedia/en/a/ae/Eddie_Aikau.jpg", 
          "Edward Ryon Makuahanai Aikau was a well-known Hawaiian "
              + "lifeguard and surfer. As the first lifeguard at Waimea Bay on the island of Oahu, he saved many lives "
              + "and became famous for surfing the big Hawaiian surf, winning several awards including the 1977 Duke "
              + "Kahanamoku Invitational Surfing Championship. Born in Kahului, Maui, Aikau was the third child of "
              + "Solomon and Henrietta Aikau. Aikau first learned how to surf at Kahului Harbor on its shorebreak. He "
              + "moved to Oahu with his family in 1959, and at the age of 16 left school and started working at the "
              + "Dole pineapple cannery; The paycheck allowed Aikau to buy his first surfboard. In 1968, he became the "
              + "first lifeguard hired by the City & County of Honolulu to work on the North Shore. The City & County "
              + "of Honolulu gave Aikau the task of covering all of the beaches between Sunset and Haleiwa. Not one "
              + "life was lost while he served as lifeguard of Waimea Bay, as he braved waves that often reached 30 "
              + "feet (9.1 m) high or more. In 1971, Aikau was named Lifeguard of the Year.", 
              "eddieaikau", "Male", "Regular"));

      /** FEMALES **/
      SurferDB.addSurfer(new SurferFormData("Megan Abubo", "Hartford, Connecticut", "United States", 
          "2004 WCT Rip Curl Malibu Pro", "http://www.lat34.com/_/Photo/_/megan_abubo05hornbaker.jpg", 
          "http://farm3.static.flickr.com/2120/2037051178_13ee5c327f.jpg", "Growing up in Hawaii, Megan quickly became"
              + " one of the 'beach boys' and worked her way to a spot on the World Championship Tour ranks in 1998."
              + " She has been on the WCT ever since and in 2000 she was runner up for the world title. She has had "
              + "many victories both in and out of the water. In October 2004 Megan won the WCT Rip Curl Malibu Pro "
              + "and shot from 14th to 9th in the ratings. In 2002, she won the WCT Figueira Pro in Portugal, and in"
              + " 2001 she won the WCT Roxy Pro in Fiji. Throughout her career she has had 5 other WCT victories.", 
          "meganabubo", "Female", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Serena Brooke", "Coolangatta, Queensland", "Australia", "Billabong Pro"
          + " Australia, 1995 Women's Rookie of the Year", 
          "http://3.bp.blogspot.com/-ayVU8U4xE_w/T9-cGiDXA3I/AAAAAAAABgo/phpoxj3jlh4/s1600/serenaIndo3.jpg", 
          "http://www.news.saltwater-dreaming.com/modules/xcgal/albums/ASP/serena-brooke.jpg", "Brooke began to compete"
              + " in amateur competitions in 1990 where she was crowned the Queensland amateur surfing title as well as"
              + " the Australian National Title. Following her graduation from high school in 1995 she entered the pro "
              + "ranks and finished her rookie season with a #13 overall ranking on the woman's tour. She was named the"
              + " 1995 Women's Rookie of the Year. Among her notable accomplishments was winning the Billabong Pro"
              + " Australia title and achieving a temporary #1 overall ranking in 2001. She would finish with #2 "
              + "ranking twice on the World Championship Tour (WCT). Serena Brooke is one of the most marketable"
              + " athletes in woman's surfing having garnered numerous sponsorships including Angel Eyewear and Bud "
              + "Light. In 2001 she starred in the surfing documentary 7 Girls, and has also starred in numerous"
              + " surfing videos and occasionally holds surfing camps for children looking to learn how to surf. In "
              + "2001, she established the Serena Brooke Charity Foundation. The foundation, which was created in"
              + " Huntington Beach, California, helps raise money for the Orange County Child Abuse Prevention Center, "
              + "CSP Youth Centers, Breast Cancer Research, and the Surfrider Foundation among others. The highlight of"
              + " the year for the foundation is the Serena Brooke Charity Day held in Huntington Beach.",
          "serenabrooke", "Female", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Nikki Van Dijk", "Phillip Island, Victoria", "Australia", "ASP 6-Star"
          + " Pantin Classic Galicia Pro Champion", 
          "http://resources0.news.com.au/images/2011/05/03/1226049/135032-nikki-van-dijk.jpg", 
          "http://www.surfcoastnews.com.au/wp-content/uploads/2012/01/05_Nikki_Van_Dijk.jpg", "Nikki's Dad taught her"
              + " to surf on the beaches of Phillip Island,where she has grown (is still growing) up. At the tender"
              + " age of 10 Nikki was talent spotted by Rip Curl and in 2007 was the youngest ever State Junior "
              + "Champion, taking out the Quiksilver State Championships at just 12 years of age. At 14, Nikki won"
              + " the local trialsfor a wildcard to compete in the main event of the Rip Curl Women’s Pro in 2009."
              + " After surfing her way to 9th place she was knocked out by team mate Steph Gilmore. Now 15, Nikki "
              + "has beenconcentrating on the Pro Junior Series and is aiming for the World Tour one day.",
          "nikkivandijk", "Female", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Daize Shayne", "Ukiah, California", "United States",
          "2004 World Longboard Champion, 1999 World Longboard Champion", 
          "http://a1.l3-images.myspacecdn.com/images02/116/b6f38436d75349ef980b8f178932fab2/l.jpg",
          "http://www.richcruz.com/images/photography/Studio-Daylight/Daize-IMG_04.jpg", "The two time world champion"
              + " longboard surfer was featured in Maxim and two issues of ReadyGo Magazine Japan in which she had"
              + " 16 full-page color photos of her modelling alongside Britney Spears and others. She has also been"
              + " featured in numerous other international magazines. Daize said she was born April 25, 1978 in Ukiah,"
              + " CA. She said, 'My full name is Sarah Rose Shayne, but Daize is the nickname that's stuck'. She is"
              + " currently married.", "daizeshayne", "Female", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Paige Hareb", "New Plymouth", "New Zealand", "2009 Taranaki Sportsperson"
          + " of the Year", "http://cdn.surf.transworld.net/files/2009/03/24/paige_hareb_288.jpg", 
          "http://www4.pictures.zimbio.com/gi/TSB+Bank+Womens+Surf+Festival+6Unkknl7qkvl.jpg", "She debuted on the ASP"
              + " World Tour in December 2008 at the Billabong Pro in Hawaii where she won her second round heat, "
              + "beating world no.2 Peru's Sofia Mulanovich. In the third round she was beaten by World Champion"
              + " Stephanie Gilmore. In her rookie year of the 2009 World Tour she reached the semi-finals of the "
              + "Roxy Pro in Coolangatta, Australia before being beaten by eventual winner, Gilmore.", "paigehareb",
          "Female", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Kelia Moniz", "Hawaii", "United States", "ASP Longboard World Title", 
          "http://4.bp.blogspot.com/_tPLV5CkprP4/TRFKxIZIlbI/AAAAAAAAAKo/ZZJVtwpj3b0/s1600/20101218_PipeLine-010.jpg", 
          "http://www1.pictures.zimbio.com/gi/DVF+Loves+ROXY+Launch+hiadGWypmZUl.jpg", 
          "Multi-talented Japanese, Hawaiian, Portuguese, Chinese, Irish beauty Kelia Moniz grew up in a surfing "
              + "family that spends more time in the water than on land. Raised with four brothers and an "
              + "ex-professional surfer for a father, Kelia (known by friends and family as Sister) definitely knows "
              + "how to surf with the boys. She proved her merit last year by being the only girl to make it to the "
              + "semifinals in the noseriding event at the Corona Hawaiian Open.", "keliamoniz", "Female", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Clarissa Moore", "Hawaii", "United States", 
          "6 ASP Women's World Tour events, 2 ASP WQS 6-Star events and 11 NSSA Titles", 
          "http://media.outsideonline.com/images/719*488/Gallery_CarissaMoore1_08052011.jpg", 
          "http://images.nationalgeographic.com/wpf/media-live/photos/000/425/cache/"
              + "carissa-moore-portrait_42534_600x450.jpg", 
          "At only 17, Carissa has already tallied quite an impressive competitive record. She is the most decorated "
              + "surfer in NSSA history, with 11 National titles. In 2008, she re-wrote the record books with her "
              + "win at the 6-Star WQS Reef Hawaiian Pro at Haleiwa, becoming the youngest competitor in ASP history to"
              + " take top podium honors at a Vans Triple Crown event. In 2007, Carissa proved she can compete and win "
              + "at the next level, twice toppling Layne Beachley, the ranking legend on the women's tour and "
              + "seven-time ASP World Champ - all on her way to a second place finish at the Roxy Pro Gold Coast. "
              + "Even more, surfing may have finally found a girl who can not only play with, but also beat the boys. "
              + "As a 14-year-old in '07, Carissa beat out 57 of Hawaii's best boys 16 and Under, to become the "
              + "first-ever female winner of a Quiksilver King of the Groms regional event.", 
          "carissamoore", "Female", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Tyler Wright", "Lennox Head, New South Wales", "Australia", 
          "2012 ASP Womens World Title (4th place), 2011 ASP Womens World Title (4th place)", 
          "http://www.elitismstyle.com/blogazine/wp-content/uploads/2013/05/tyler-wright.jpg", 
          "http://media.melty.fr/article-957237-ajust_930/l-australienne-tyler-wright.jpg", 
          "Following in the footsteps of older brother Owen, 16-year old Aussie Tyler Wright detonated "
              + "mind-boggling performances on the ASP World Ranking to finish at No. 3 overall and solidify her "
              + "position on the Top 17 at only 16 years of age. Wright’s title as a childhood prodigy is due to an "
              + "impressive list of accolades including her win at the Beachley Classic at just 14 years of age, "
              + "making her the youngest surfer of all time to win an ASP World Tour event. The young powerhouse "
              + "showed she’s only just begun however; as she went on to clinch the O’Neill World Cup of Surfing "
              + "last year, showing the remainder of this year’s Top 17 that she’ll be a dangerous draw in 2011.", 
          "tylerwright", "Female", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Bianca Buitendag", "Victoria Bay, South Africa", "South Africa", 
          "2012 ASP Womens Star Ranking (2nd place), 2011 Billabong ASP World Junior Surfing Champion", 
          "http://www.zigzag.co.za/wp-content/gallery/womens-day/9bianca3.jpg", 
          "http://a0.twimg.com/profile_images/378800000115523669/82d7e344b5c14bf9217bc63be8536621.jpeg", 
          "Bianca grew up in a Surfing family with two brothers, surfing from age 7.  She learned to surf in "
              + "the beach breaks of the Strand as well as at the Jongensfontein point break.  The family then moved "
              + "to Victoria Bay when she was age 11.  It was here that Bianca started focusing more on competitive "
              + "surfing.  Bianca soon stood out at a young age winning the Billabong u/20 girls finals at age 13 as "
              + "well as coming 9th at Mr Price WQS at age 14.  By the year 2009 Bianca won every single contest she "
              + "entered in South Africa.", 
          "biancabuitendag", "Female", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Sofia Mulanovich", "Lima, Peru", "Peru", 
          "2004 ASP Women’s World Champion", 
          "http://a4.espncdn.com/photo/2013/0924/as_surf_riss_2048.jpg", 
          "http://www.fanphobia.net/uploads/actors/16940/sofia-mulanovich-profile-picture.jpg", 
          "Professional surfer Sofia Mulanovich grew up in Punta Hermosa, a small town outside of Lima, where she "
              + "rode a body board at 5 and graduated to a short board by age 9. At 12, she sharpened her lethal "
              + "backside skills on Peru's many perfect lefts. Encouraged and nurtured by her family and friends, "
              + "Sofia's natural surfing talent soon gave way to major results as she charged against the boys in local"
              + " competitions. She turned pro in 1999 at the age of 16, already well into five consecutive Peruvian "
              + "National Championships and scored a sponsorship from ROXY that same year. Nicknamed 'La Gringa' "
              + "back home for her blue eyes and blond-streaked hair, Sofia has drive, graciousness and uncanny "
              + "natural surf ability in her DNA, all the makings of a true athletic hero. Fearless Sofia is known "
              + "for her persistence and commitment to the sport of surfing. Sofia's turn on the world stage began "
              + "with an impressive year on the World Qualifying Series in 2002, ultimately earning her a spot on "
              + "the World Championship tour. Ever determined, she nabbed the 2003 WCT Rookie of the Year title with "
              + "her hard-charging style, finishing the season with a top-ten ranking. 2004 started off with an "
              + "auspicious win. In Salinas, Ecuador she took the title of 2004 ISA World Champion, propelling the "
              + "Peruvian teams standing to an unprecedented fourth place with her win. This marked the beginning of "
              + "greatness for Sofia and her country. She rocked the 2004 WCT season with three consecutive wins in "
              + "Fiji, Tahiti and France and second places at the US Open and the ROXY Pro in Haleiwa.", 
              "sofiamulanovich", "Female", "Regular"));

      /** GROMS **/
      SurferDB.addSurfer(new SurferFormData("Kalani David", "Haleiwa, Hawaii", "United States", 
          "2013 Rip Curl Grom Search",
          "http://www.rvca.com/media/transfer/img/tom_0941_2.jpg",
          "http://cdn.surf.transworld.net/wp-content/blogs.dir/443/files/2012/10/Kalani-David.jpg", "It's unlikely old"
              + " age will be kind to Kalani David. The 14-year-old Costa-Rica-born-Hawaiian-pro-skater-slash-pro-"
              + "surfer is looking very uncomfortable seated across from me at a roadside eatery in Bali. The World "
              + "Junior Championships are on and as of yesterday, he is now the highest ranked surfer in the world "
              + "for his age (having lost out in Round 4 to one of the event favorite's, Conner Coffin). His biggest "
              + "battle at the moment, however, is trying to reach the fried chicken on his plate. ", "kalanidavid", 
              "Grom", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Elliot Ivarra", "Saint Barthelemy", "France", "Quiksilver King of "
              + "the Groms", "http://farm9.staticflickr.com/8177/8071333879_f8f9567017_b.jpg", 
          "http://static.quiksilver-europe.com/www/quiksilverlive.com/html/upload/kotg2012/riders/__ID-33--5-ellioti"
             + "varra.jpg", "Elliot Ivarra, 16, was born in Saint Martin, but lives in Saint Barthelemy Island. French "
             + "surfer Elliot Ivarra won the European final of the Quiksilver King of the Groms in 3 feet fun waves "
             + "at Ericeira, Portugal. The young french surfer had won his ticket for the Quiskslver King Of the Groms"
             + " Euro Final thanks to his first place in trials yesterday. This place allowed him to compete in the"
             + " main event. In Ericeira, the Frenchman ruled this final heat of competition with several backside"
             + " tricks scoring to fun waves 5.83 pts then a last one 7.43 pts for a final score of 13.50 pts. His "
             + "domination upon Europe's best 16 and under surfers was unquestionable even if the young French kid "
             + "Nomme Mignot battled hard for the crown until the very last seconds of the heat. As he was leading the"
             + " final, Nomme, from Surfing French Team, let Elliot the victory. None the less, both of them will fly "
             + "to France to take part to the Quiksilver King of the Groms International final to be held during the "
             + "Quiksilver Pro France - an ASP World Tour event- (From September 27th to October 8th) gathering the"
             + " world's best surfers on the Landes coast. An extraordinary experience for these two groms.", 
              "elliotivarra", "Grom", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Kyuss King", "Byron Bay, New South Wales", "Australia", 
          "2011 U12 NSW State Titles Champion", "http://kyussking.com/au/wp-content/uploads/2012/02/kyuss-king.jpg",
          "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2013/05/may2012_wiho_pic.jpg", 
          "At the age of 4 Kyuss featured on the front cover of the local newspaper"
              + " surfing across a green face solo out the Pass and with a stance that true of a grounded point"
              + " surfer. Kyuss’s surfing talents were soon noticed by the surf brands and was sponsored by Volcom"
              + " at the age of 6. Kyuss loved competing and went on to win many national junior events over the"
              + " past years and recently claimed the 2011 U12 NSW State Titles Championship and added 2 perfect"
              + " 10 point rides at state level.", "kyussking", "Grom", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Johanne Defay", "Le Puy-en-Velay", "France", 
          "Swatch Girls Pro France Junior", "http://www.surfersvillage.com/img/st/1208-LA_Johanne-Defay-FRA.jpg", 
          "http://static.panoramio.com/photos/large/35171150.jpg", "Johanne was born"
              + "  the 19 of november, 1993 in Metropolitan France but she has spent her entire childhood in Reunion"
              + " Island where she discovered surfing. Since then, her only goal has always been to improve her surf"
              + ", earning titles in order, one day, to integrate the surfing elite: The Women ASP World Championship"
              + " Tour. Besides being an incredible surfer, Johanne is a great woman always with a huge smile on her"
              + " face, curious to discover the world thanks to her numerous surf trips, happy to share with people"
              + " and also a great artist. When she has the time, she takes her pencils, pastels and other colorful"
              + " stuff and starts painting where her imagination takes her.", "johannedefay", "Grom", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Reika Noro", "Higashiosaka-shi, Osaka", "Japan", "All Japan Junior NSA "
          + "Championship", "http://www.aspjapantour.com/webcast/2012/hyugajr/photos/images/6301.girls_reika_noro.jpg",
          "http://hrdfilms.com/wp-content/uploads/2013/08/1afb884717c2dadb90e7d92798d517bb.jpg", "Reika began surfing"
              + " at the age of 13 and has won a number of Japanese tournaments. Although she has yet to get big splash"
              + "in the world stage, she is determined to do her best to make it.", "reikanoro", "Grom", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Kaulana Apo", "Oahu, Hawaii", "United States", "None", 
          "http://www.surfermag.com/hot-100/img/grm10.jpg",
          "http://2.bp.blogspot.com/_IMTICxzEzp4/SJaw9VFQ1UI/AAAAAAAAAnY/RVzUwE8A-eI/s320/kaulana.jpg", 
          "Goofy footer from Ewa Beach Having honed his polished surf style on the rippable peaks of Kewalo "
              + "Basin, Kaulana Apo is quickly headed for big things. And it might not just be surfing. Kaulana "
              + "is focused on doing well in school, and is interested in art. While a lot of junior surfers have "
              + "one track minds, Kaulana is a unique and creative talent.", "kaulanaapo", "Grom", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Jake Marshall", "Encinitas, California", "United States", "2013 King of the Groms", 
          "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2011/02/JakeMarshall01-677x442.jpg",
          "http://www.nssa.org/photogallery/gallery/2008-09_SEASON/JMarshallswO.jpg", 
          "Many young surfers have the potential to make an impact on our sport, "
              + "but none look more poised to do so than Jake Marshall. "
              + "Raised on the rippable beachbreaks and reefs of San Diego's North County, "
              + "Jake has developed a solid base of smooth rail work as well as "
              + "the kind of flair that few 14-year-old surfers can match.  "
              + "Already, he's had remarkable success in a jersey, including a recent win at the U.S. Surfing "
              + "Championships at Lower Trestles. But while surf stardom seems inevitable for Jake, he's still just a "
              + "kid, and knows where his priorities should be. ", "jakemarshall", "Grom", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Sebastian Williams", "Oaxaca, Mexico", "Mexico", 
          "2013 RVCA Junior Surf Series(2nd Place)", 
          "http://www.uaposurf.com/wp-content/uploads/2011/11/Sebastiancutback.jpg",
          "http://www.uaposurf.com/wp-content/uploads/2011/11/sebsatiandempsey.jpg", 
          "Mexican surfing supergrom, Sebastian Williams, 12, looks set to make a huge impression amongst South "
              + "Africa’s top junior surfers when he competes in the inaugural RVCA Junior Series in Jeffreys Bay "
              + "from 22-24 March. On his first trip to the country with his father, former Durbanite Tim Williams, "
              + "Sebastian had everyone who saw him surfing in Cape Town on the weekend asking, 'Who is that kid?', "
              + "with his phenomenal talent in the waves, cutting edge equipment and mature attitude. Rated in the "
              + "prestigious Surfer Mag ‘Hot 100 Groms’ list in both 2011 and 2012.", 
          "sebastianwilliams", "Grom", "Regular"));
      
      SurferDB.addSurfer(new SurferFormData("Nomme Mignot", "French Basque", "France", 
          "King of the Groms 2012", 
          "http://isawjsc.com/2013/wp-content/gallery/event_day_3_selected/fra_nomme_mignot4_tweddle.jpg",
          "http://media.melty.fr/article-1042978-ajust_930/nomme-mignot.jpg", 
          "Born in Panama, the formative years of Nomme Mignot’s life was spent was onboard his nomadic "
              + "parents’ yacht, sailing and surfing the waves of the South Pacific, Central America, South America, "
              + "the Caribbean, Australia, Europe and North America. Eventually finding a home on dry land in the " 
              + "Mexican surf village of Sayulita, Nayarit, Nomme began to hone his skills at a young age alongside " 
              + "some of the top professional surfers in Mexico, as well as his elder cousin Diego. The result is an "
              + "exceptional well-rounded athlete, both in and out of the water. Although a natural wit, in any of "
              + "the three languages he speaks fluently, it is his results in the ocean that have seen him earmarked "
              + "as a future star. In 2012 he came fifth in the  ISA World Championships as well as winning the French "
              + "King Of The Groms title, all while improving his ranking on the ASP European Junior Series.  Nomme "
              + "represents of a new generation of surfers, one that combines powerful carves and progressive aerials, "
              + "comfortable in any waves, anywhere. Our advice is to look out for Nomme Mignot, it is a name that will"
              + " be a big part in pushing the sport of surfing.", 
          "nommemignot", "Grom", "Goofy"));
      
      SurferDB.addSurfer(new SurferFormData("Quincy Davis", "Montauk, New York", "United States", 
          "2009 Volcom Qualifying Series (Girls)", 
          "http://www.oakley.com/a/3f/3b/BAh7CGkKIgo4MDB4MGkLbCsHO16OUGkIaQMhBAM.jpg",
          "http://www.oakley.com/a/56/ef/BAh7CGkKIgo0NjJ4MGkLbCsHPSN2UGkIaQPQ4wI.jpg", 
          "Quincy was born in Montauk, New York; at just 7-years-old she started surfing. With the shore as her "
              + "backyard, Quincy spent long summer days at the beach with her family who were always surfing. After "
              + "becoming bored of swimming and running around she decided to give surfing a try.[2] She picked it up "
              + "quickly with the help of her brother and father teaching her[3] and she never stopped. She started "
              + "attending local surf events with older friends and would sometimes compete herself but always against "
              + "the boys because there weren't any other girls in her age division. Her amateur career started when "
              + "she came home with trophies and her mother decided to enter her into more events. Quincy accredits "
              + "her family and friends for her constant surfing inspiration and support. Her family has a home in "
              + "Rincon, Puerto Rico where they spend their winters.[4] Splitting her time between her two homes, "
              + "Quincy enjoys traveling and competing worldwide and hopes to one day qualify for the ASP Women’s "
              + "WCT. Like most young women, Quincy has passions outside of the surf world that include music, "
              + "Christmas movies and all things fashion. In 2013, Quincy collaborated with her sponsor Volcom, "
              + "inspiring and designing a clothing collection for Spring and Fall.", 
          "quincydavis", "Grom", "Regular"));
    }

  }

}
