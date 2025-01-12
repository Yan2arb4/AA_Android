using AA_Backend.Configuration;
using AA_Backend.Models;
using AA_Backend.Models.DTO;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using NuGet.Common;
using NuGet.Protocol.Plugins;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

namespace AA_Backend.Controllers
{
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        readonly UserManager<User> _userManager;
        readonly string _secretKey;

        public UsersController(UserManager<User> userManager, IOptions<JwtSettings> jwtSettings)
        {
            _userManager = userManager;
            _secretKey = jwtSettings.Value.SecretKey;
        }

        [HttpPost]
        public async Task<ActionResult> Register(RegisterDTO register)
        {
            if(register.Password != register.PasswordConfirm)
            {
                return StatusCode(StatusCodes.Status400BadRequest,
                    new { Message = "Password and confirm password fields are different." });
            }

            User user = new User() { UserName = register.Username, Email = register.Email };

            IdentityResult identity = await this._userManager.CreateAsync(user, register.Password);
            if (!identity.Succeeded)
            {
                return StatusCode(StatusCodes.Status500InternalServerError,
                    new { Message = "Failed at creating user." });
            }

            return Ok( new { Message = "User successfully created !"});
        }

        [HttpPost]
        public async Task<ActionResult> Login(LoginDTO login)
        {
            User? user = await _userManager.FindByNameAsync(login.Username);
            if(user == null)
                user = await _userManager.FindByEmailAsync(login.Email);

            if (user == null || !await _userManager.CheckPasswordAsync(user, login.Password))
                return StatusCode(StatusCodes.Status400BadRequest,
                    new { Message = "Username or password is wrong, could not find user." });

            //Thinking of adding admin so leaving that there for now
            IList<string> roles = await _userManager.GetRolesAsync(user);
            List<Claim> authClaims = new List<Claim>();
                
            foreach(string role in roles)
                authClaims.Add(new Claim(ClaimTypes.Role, role));
            authClaims.Add(new Claim(ClaimTypes.NameIdentifier, user.Id));

            SymmetricSecurityKey key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_secretKey));
            JwtSecurityToken token = new JwtSecurityToken(
                issuer: "https://localhost:7107",       //Server
                audience: "https://localhost:8000",     //Client
                claims: authClaims,
                expires: DateTime.Now.AddHours(1),
                signingCredentials: new SigningCredentials(key, SecurityAlgorithms.HmacSha256Signature)
                );

            return Ok(new 
            { 
                token = new JwtSecurityTokenHandler().WriteToken(token),
                validTo = token.ValidTo
            });
        }
    }
}
